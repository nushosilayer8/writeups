# CrossCTF Finals 2018 : Perfect (re)

> 'Cause we lost it all Nothin' lasts forever
> 
> Creator - amon (@nn_amon) Update: this definitely works with python 2.7.15

## Challenge
We were given a binary [perfect](./perfect).

Opening it up in IDA gives us the following pseudocode.

```
__int64 __fastcall main(__int64 a1, char **a2, char **a3)
{
  __int64 v3; // rdx
  __int64 v4; // rdx
  __int64 v5; // rdx
  __int64 v6; // rdx
  char v8; // [rsp+10h] [rbp-460h]
  char v9; // [rsp+20h] [rbp-450h]
  int v10; // [rsp+24h] [rbp-44Ch]
  char v11; // [rsp+30h] [rbp-440h]
  int v12; // [rsp+34h] [rbp-43Ch]
  char v13; // [rsp+40h] [rbp-430h]
  char v14; // [rsp+50h] [rbp-420h]
  char v15; // [rsp+60h] [rbp-410h]
  unsigned __int64 v16; // [rsp+468h] [rbp-8h]

  v16 = __readfsqword(0x28u);
  __gmpz_init(&v8);
  __gmpz_set_ui(&v8, 0LL);
  __gmpz_init(&v9);
  __gmpz_set_ui(&v9, 0LL);
  __gmpz_init(&v11);
  __gmpz_set_ui(&v11, 0LL);
  __gmpz_init(&v13);
  __gmpz_set_ui(&v13, 0LL);
  __gmpz_init(&v14);
  __gmpz_set_ui(&v14, 2LL);
  __gmpz_mul_2exp(&v14, &v14, 212LL);
  printf("Eschucha? ", &v14);
  __isoc99_scanf("%1023s", &v15);
  if ( (unsigned int)__gmpz_set_str(&v11, &v15, 10LL) )
    __assert_fail("flag == 0", "perfect.c", 0x20u, "main");
  __gmpz_sub_ui(&v11, &v11, 1LL);
  if ( (unsigned int)__gmpz_set_str(&v13, &v15, 10LL) )
    __assert_fail("flag == 0", "perfect.c", 0x23u, "main");
  while ( v12 < 0 || v12 > 0 )
  {
    __gmpz_mod(&v9, &v13, &v11);
    if ( v10 >= 0 && v10 <= 0 )
      __gmpz_add((__int64)&v8, (__int64)&v8, (__int64)&v11);
    __gmpz_sub_ui(&v11, &v11, 1LL);
  }
  if ( !(unsigned int)__gmpz_cmp(&v13, &v8) && (signed int)__gmpz_cmp(&v13, &v14) > 0 )
  {
    printf("random.seed(");
    __gmpz_out_str(_bss_start, 10LL, &v8);
    puts(")");
    puts("k = \"\".join([chr(random.randint(0, 255)) for i in range(35)])");
    puts("xor(k, 754e26ccd4b1bfafb3ffbdaa748780b7f0e0c3ae9acc3c008670f0fafd34f8ffa596db)");
  }
  __gmpz_clear((__int64)&v8);
  __gmpz_clear((__int64)&v13);
  __gmpz_clear((__int64)&v11);
  __gmpz_clear((__int64)&v9);
  __gmpz_clear((__int64)&v14);
  return 0LL;
}
```

### mpz API
Before continuing, we need to know what does the `_gmpz_xxx` functions do. Referring to the [gmplib manual](https://gmplib.org/manual), we get that

* `__gmpz_init` initializes an address to be a `mpz` object.
* `__gmpz_set_ui` sets a `mpz` object with an unsigned int provided as the 2nd argument.
* `__gmpz_mul_2exp` left shifts the 2nd argument by the 3rd argument and stores the result in the 1st argument.
* `__gmpz_add` stores the sum of the 2nd argument and the 3rd argument in the 1st argument.
* `__gmpz_sub_ui` subtracts the 2nd argument by the 3rd argument and stores the result in the 1st argument.
* `__gmpz_set_str` takes the string in the 2nd argument and stores it in the 1st argument, with the 3rd argument being the base.
* `__gmpz_out_str` outputs the value of the 3rd argument, with the 2nd argument as the base, and the 1st argument being the output stream.
* `__gmpz_mod` takes the result of 2nd argument modulo 3rd argument and stores it in the 1st argument.
* `__gmpz_cmp` compares the two arguments and returns a positive number if op1 > op2, zero if op1 = op2, negative number if op1 < op2.

### pseudocode
So, we can simplify the code above further to be
```
v8 = 0
v9 = 0
v11 = 0
v13 = 0
v14 = 2 << 212

scanf("%1023s", &v15)

v11 = int(v15) - 1
v13 = int(v15)

while (v12 != 0) {
	v9 = v13 % v11
	if (v10 == 0)
		v8 += v11
	v11--;
}

if (v13 == v8 && v13 > v14)
	print "random_seed(" + v8 + ")"
    puts("k = \"\".join([chr(random.randint(0, 255)) for i in range(35)])");
    puts("xor(k, 754e26ccd4b1bfafb3ffbdaa748780b7f0e0c3ae9acc3c008670f0fafd34f8ffa596db)");
```

So, it looks like the program requests for a number, and does some computations and comparisons with it, and if it passes all checks it gives us a seed that can be used to generate the flag.

Hmm, suddenly there's `v12` and `v10` which we did not initialize at the start. We need to know what they are since the whole control flow relies on them.

Looking back at the top of our original pseudocode

```
char v8; // [rsp+10h] [rbp-460h]
char v9; // [rsp+20h] [rbp-450h]
int v10; // [rsp+24h] [rbp-44Ch]
char v11; // [rsp+30h] [rbp-440h]
int v12; // [rsp+34h] [rbp-43Ch]
char v13; // [rsp+40h] [rbp-430h]
char v14; // [rsp+50h] [rbp-420h]
char v15; // [rsp+60h] [rbp-410h]
```

We see that each `mpz` value, `v8`, `v9`, `v11`, `v13` and `v14` are 16 bytes away from each other on the stack. So they all probably are 16 bytes long. On the other hand, `v10` points to the address at an offset of 4 bytes from the address of `v9`, and same for `v12` and `v11`.

### mpz internals
To confirm our doubts, we refer to the [manual](https://gmplib.org/manual/Integer-Internals.html#Integer-Internals). We see that each `mpz_t` variable is a `struct` with the following fields.

#### \_mp_size
The number of limbs, or the negative of that when representing a negative integer. Zero is represented by `_mp_size` set to zero, in which case the `_mp_d` data is unused.

#### \_mp_d
A pointer to an array of limbs which is the magnitude. These are stored “little endian” as per the mpn functions, so `_mp_d[0]` is the least significant limb and `_mp_d[ABS(_mp_size)-1]` is the most significant. Whenever `_mp_size` is non-zero, the most significant limb is non-zero.

#### \_mp_alloc
`_mp_alloc` is the number of limbs currently allocated at `_mp_d`, and naturally `_mp_alloc >= ABS(_mp_size)`. When an mpz routine is about to (or might be about to) increase `_mp_size`, it checks `_mp_alloc` to see whether there’s enough space, and reallocates if not. `MPZ_REALLOC` is generally used for this.

But the manual didn't tell us which field is at which offset. So, we used [onlinegdb](https://www.onlinegdb.com/online_c_compiler) to test it out, using the following code.

```
#include <stdio.h>
#include <gmp.h>
int main()
{
   mpz_t g;
   printf("_mp_size\t%d\n", (size_t)&(g->_mp_size)-(size_t)&g);
   printf("_mp_d\t\t%d\n", (size_t)&(g->_mp_d)-(size_t)&g);
   printf("_mp_alloc\t%d\n", (size_t)&(g->_mp_alloc)-(size_t)&g);
   return 0;
}
```

We get the following output

```
_mp_size        4         
_mp_d           8         
_mp_alloc       0
```

So, `v10` and `v12` are pointing the `_mp_size` field of `v9` and `v11`. Checking if they are 0 is equivalent to checking if `v9` and `v11` are equal to 0.

Cleaning up our pseudocode

```
scanf("%1023s", &v15)

v11 = int(v15) - 1
v13 = int(v15)

while (v11 != 0) {
	if (v13 % v11 == 0)
		v8 += v11
	v11--;
}

if (v13 == v8 && v13 > 2^213)
	print "random_seed(" + v8 + ")"
    puts("k = \"\".join([chr(random.randint(0, 255)) for i in range(35)])");
    puts("xor(k, 754e26ccd4b1bfafb3ffbdaa748780b7f0e0c3ae9acc3c008670f0fafd34f8ffa596db)");
```

We see above that `v8` is the sum of all factors of `v13`, then the program checks if it is equal to our original input, and if it is greater than 2^213. Then, our seed will just be our input number.

This means we are looking for [perfect numbers](https://en.wikipedia.org/wiki/List_of_perfect_numbers) greater than 2^213. 

## Solution
Since there are a lot of numbers satisfying the condition, we take a few *p*s from the wikipedia page, and try them out. We will not run the program with these numbers, since it would take **very** long.

Cleaning up the code that is supposedly given
```
import random
from pwn import *

nums = [107, 127, 521, 521, 607, 1279]

def perfectexp(p): return (2**(p-1))*(2**p-1)

def run(x):
    random.seed(perfectexp(x))
    k = "".join([chr(random.randint(0, 255)) for i in range(35)])
    print(xor(k, '754e26ccd4b1bfafb3ffbdaa748780b7f0e0c3ae9acc3c008670f0fafd34f8ffa596db'.decode('hex')))

for i in nums:
    run(i)
```

Running it gives us
```
H\x88*]\xb6\xa3\x8e�$�Q�5U�kNn{-���_��h�&�7mZ\x8d
CrossCTF{why_am_1_aw4ke_r1ght_n0ww}
qF    V\x18\x8e\x9a.�LQ1\x9c\xbc\xa4]\x0f���em\xa3c%V\x1b�\x18\xa2\xae@S\x9c
qF    V\x18\x8e\x9a.�LQ1\x9c\xbc\xa4]\x0f���em\xa3c%V\x1b�\x18\xa2\xae@S\x9c
��\��{�-�?3l]L\x92B&*9[M��=�@����g�
4~qB\xaf�^=\x0f�w�5p \xbe�y�i\xa4o��^\x88<\x81&�;�
```