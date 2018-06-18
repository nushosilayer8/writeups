# CrossCTF Finals 2018 : Rochefort 6 (re)

> Nothing like a Rochefort 6 in the hot summer weather...
>
> nc ctf.pwn.sg 16667
> 
> Creator - waituck (@wongwaituck)

[binary](./towerofbeer)

This challenge uses the same binary as [Rochefort 8](../rochefort8)

## Analysis
At first the program prompts for a number, 6 would execute the code for this challenge, while 8 for the other challenge.

Opening up the function for 6 in IDA gives us

```
unsigned __int64 sub_400AC3()
{
  signed __int64 v0; // r12
  unsigned int v1; // eax
  int v2; // eax
  unsigned int v3; // er13
  __int64 v4; // r14
  char s; // [rsp+0h] [rbp-430h]
  unsigned __int64 v7; // [rsp+408h] [rbp-28h]

  v0 = 20LL;
  v7 = __readfsqword(0x28u);
  v1 = time(0LL);
  srand(v1);
  do
  {
    v2 = rand();
    v3 = (unsigned __int16)(v2 + ((unsigned __int64)v2 >> 48)) - ((unsigned int)(v2 >> 31) >> 16);
    puts("Bet you can't produce the same output :P");
    printf("%d\n", v3);
    puts("Your turn: ");
    if ( !fgets(&s, 1024, stdin) )
    {
      puts("Couldn't read your input.");
      exit(1);
    }
    v4 = (unsigned int)sub_400A7F((unsigned __int8 *)&s, strlen(&s));
    printf("Your output is %d\n", v4);
    if ( v3 != (_DWORD)v4 )
    {
      puts("FAIL");
      exit(2);
    }
    --v0;
  }
  while ( v0 );
  sub_400C0A();
  return __readfsqword(0x28u) ^ v7;
}
```

In short, what the program does is it generates a random number, then performs some bit shifting on it. We are then prompted for a string, which will be passed into a function and the result of it will be compared with the number mentioned earlier.

*For those without IDA (Pro version), and had to read the assembly themselves, they would have gotten a block of assembly code that doesn't look so obvious to be `strlen` but I believe by playing around with it for a bit, it would have been clear that it is.*

Let's look at the function at 0x400a7f.

```
__int64 __fastcall sub_400A7F(unsigned __int8 *a1, __int64 a2)
{
  __int64 result; // rax
  unsigned __int8 *v3; // r12
  unsigned __int8 *v4; // rbx
  int v5; // edi

  if ( !a2 )
    return 0LL;

  result = 0;
  v3 = &a1[a2];
  v4 = a1;
  do
  {
    v5 = *v4++;
    result = sub_400AB2((signed int)result + v5);
  }
  while ( v3 != v4 );
  return (unsigned __int16)result;
}
```

Here it seems that the program just takes every byte of the string, or more precisely its ASCII value, adds it to the current result, and calls the function at 0x400AB2 on the sum.

Looking at 0x400AB2

```
__int64 __fastcall sub_400AB2(int a1)
{
  return (unsigned int)(1131573107 * a1 + 1933792326);
}

```

Over here, I was in doubt of whether the multiplication was signed or unsigned, so I decided to look at the assembly.

```
/ (fcn) fcn.00400ab2 17                                 
|   fcn.00400ab2 ();
|              ; UNKNOWN XREF from 0x00400a9d (fcn.00400a7f)
|              ; CALL XREF from 0x00400a9d (fcn.00400a7f)
|           0x00400ab2      69c7736f7243   imul eax, edi, 0x43726f73
|           0x00400ab8      55             push rbp
|           0x00400ab9      4889e5         mov rbp, rsp
|           0x00400abc      0546544373     add eax, 0x73435446   
|           0x00400ac1      5d             pop rbp   
\           0x00400ac2      c3             ret    
```

So it uses `imul`, which is signed assembly. We also noticed that the operands of `imul` and `add` are `eax` which is the lower 32 bits. But this probably didn't really matter to our solution.

## Solution
Solving this looks easy, we can just write a z3 script.

To recap, the program

1. Takes a string as user input
2. Goes through every byte and takes its ASCII value
3. Adds that value to result
4. Multiplies result with a large number and add another large number to it

As mentioned, we will use z3 to solve this. So, let's prepare the functions that are being used in the challenge first.

```
# 0x400ab2
def ab2(a):
	return 0x43726f73 * a + 0x73435446

# 0x400a7f
def a7f(a1, a2):
	res = 0
	for i in range(a2):
		res = ab2(res + ZeroExt(24, a1[i]))

	return Extract(15, 0, res)
```

Notice that at the end of the pseudocode for 0x400a7f there was a cast to `unsigned __int16`, in assembly there was a `movzx eax, ax`, so the final result of a7f will have its higher 16 bytes removed.

Since the numbers are all playing in 64-bit space, there will be overflowing happening, especially since the multiplication and addition are with such large numbers. For this, we used a `BitVec` from z3, which is a vector of bits that behaves like how integers do in C programs.

We populate an array of `BitVec`s, which are 8 bit long. Then, we just pass that array into the functions we defined earlier.

```
s = Solver()

inp = []
for j in range(1023):
	inp.append(BitVec('%d.%d' % (i, j), 8))

outp = a7f(inp, len(inp))
```

Now, we just need z3 to solve for the current input that would provide the output we want. Before that, we need to add a constraint so that the output using that input would match the output given by the challenge.

```
s.append(outp == value)
s.check()

try:
	m = s.model()
except Exception:
	exit(0)

sol = []
for j in range(1023):
	sol.append(chr(m[inp[j]].as_long()))
return ''.join(sol)
```

But this didn't work..., because apparently when we send in our input it will end with a newline byte (0x0a). So, we need to add a constraint, that the last byte is equal to 0x0a.

```
s.append(inp[i - 1] == 0x0a)
```

Finally, because the input size could range from 1 to 1024, trying to solve for when the size is 1023 is not a wise idea. We made it such that it will try different lengths ranging from 1 to 1024.

```
def solve_for(value):
	for i in range(1, 1024):
		s = Solver()
		inp = []
		for j in range(i):
			inp.append(BitVec('%d.%d' % (i, j), 8))

		s.append(inp[i - 1] == 0x0a)

		outp = a7f(inp, len(inp))

		s.append(outp == value)

		s.check()

		try:
			m = s.model()
		except Exception:
			continue

		sol = []
		for j in range(i):
			sol.append(chr(m[inp[j]].as_long()))
		return ''.join(sol)
```

All is left is to connect to the server, and solve their outputs. Earlier in our pseudocode, we see that the program asks for a number 20 times, so we had to run a loop.

```
r = remote('ctf.pwn.sg', 16667) # process('./towerofbeer')
r.sendline('6')

for i in range(20):
	r.recvuntil(":P\n")
	num = int(r.recvuntil("\n").strip())

	print num
	ans = solve_for(num)
	r.send(ans)
	r.recvuntil('Your turn:')
	print r.recv()
	print r.recv()

r.interactive()
```

You can get the whole solution script [here](./solve.py).

### Some eye candy
[![asciicast](https://asciinema.org/a/d0xTCsWDQJCqgbwlFA2rCuLeA.png)](https://asciinema.org/a/d0xTCsWDQJCqgbwlFA2rCuLeA)