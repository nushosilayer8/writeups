# CrossCTF Finals 2018 : GruffyBear (Pwn)
### First Blood by : N0X10U5 G4S3S

>There's something fishy about this Build-A-Bear workshop...
>
>nc ctf.pwn.sg 4002
>
>Creator - amon (@nn_amon)

## Static Analysis
Running ```file gruffybear``` gives:
```
gruffybear: ELF 64-bit LSB shared object, x86-64, version 1 (SYSV), dynamically linked, interpreter ld-2.23.so, for GNU/Linux 2.6.32, BuildID[sha1]=405edd7cd41e309d1cab442ffc6a6dad8e782908, not stripped
```

The code:
``` c
int __cdecl main(int argc, const char **argv, const char **envp)
{
  int v4; // [rsp+4h] [rbp-24h]
  unsigned __int64 v5; // [rsp+8h] [rbp-20h]

  v5 = __readfsqword(0x28u);
  setvbuf(stdin, 0LL, 2, 0LL);
  setvbuf(stdout, 0LL, 2, 0LL);
  setvbuf(stderr, 0LL, 2, 0LL);
  v4 = 999;
  alarm(0x3Cu);
LABEL_2:
  while ( v4 )
  {
    while ( 2 )
    {
      print_banner();
      _isoc99_scanf("%d", &v4);
      switch ( v4 )
      {
        case 1:
          build_bear();
          goto LABEL_2;
        case 2:
          select_bear();
          goto LABEL_2;
        case 3:
          delete_bear();
          goto LABEL_2;
        case 4:
          print_bear();
          goto LABEL_2;
        case 5:
          add_comment();
          goto LABEL_2;
        case 6:
          print_comment();
          goto LABEL_2;
        case 7:
          destruction();
          if ( !v4 )
            return 0;
          continue;
        default:
          puts("Nothing to do.");
          break;
      }
      break;
    }
  }
  return 0;
}
```
```main()``` does some setup like turning off buffering, and calling ```alarm(0x3cu)```. This sets us on a time limit, after which the program will crash.

>Make sure to ```nop``` the call to ```alarm()``` using your tool. e.g. in ```radare2``` you would go to the address of the call then ```wx 9090909090``` .

In a loop, we print a banner, then get input. Based on the input, we call functions. This is a typical menu-based cli program.

``` c
unsigned __int64 build_bear()
{
  __int64 v0; // rbp
  bear *v1; // rbx
  const char *v3; // rbx
  char buf; // [rsp+7h] [rbp-21h]
  unsigned __int64 v5; // [rsp+8h] [rbp-20h]

  v5 = __readfsqword(0x28u);
  v0 = num_bears[0];
  if ( num_bears[0] > 12 )
  {
    v3 = "SUNIATRETNE";
    _printf_chk(1LL, "Here we are now... ");
    while ( 1 )
    {
      read(0, &buf, 1uLL);
      if ( v3[10] != buf )
        break;
      if ( --v3 == "nt" )
      {
        read(0, &buf, 1uLL);
        admin_enabled = 1;
        return __readfsqword(0x28u) ^ v5;
      }
    }
  }
  else
  {
    v1 = (bear *)calloc(1uLL, 0xB8uLL);
    bears[v0] = v1;
    _printf_chk(1LL, "Bear Name: ");
    read(0, v1, 0x1FuLL);
    _printf_chk(1LL, "Bear ID: ");
    _isoc99_scanf("%x", &v1->id);
    _printf_chk(1LL, "Bear Age: ");
    _isoc99_scanf("%d", &v1->age);
    _printf_chk(1LL, "Bear Description: ");
    read(0, v1->description, 0x80uLL);
    v1->free_function = (__int64)&free;
    v1->self_destruct_device_ptr = (__int64)self_destruct_device;
    puts("Bear created!");
    ++num_bears[0];
  }
  return __readfsqword(0x28u) ^ v5;
}
```
The typical functionality of ```build_bear()``` is to allocate ```0xb8``` size of memory using malloc() then initialize it using user-provided values, then set the global ```bears``` array's last unused element to our the address of the bear (```bears[v0]=v1```, where v0 is the ```num_bears). The 'bear' struct seems to as follows:
    
```
struct bear{
    char name[32];
    int id;
    int age;
    char desc[128];
    void* free_ptr;
    void* self_destruct_device_ptr;
}
```

Once we have 13 bears built already, we enter some sort of secret section, which lets us set ```admin_enabled``` to 1, as long as we satisfy some checks. In short, what the checks really want are the characters of "SUNIATRETNE" in reverse.

> IDA Pro sometimes goofs up its decompiler. What the ```v3-- == "nt"``` really means is ```v3-- == (__int64)SUNIATRETNE"-1```, or whether v3-- points to the byte before the "S".

> The above can be simplified to
```c
v3 = (__int64)"SUNIATRETNE"; // v3 is a POINTER
_printf_chk(1LL, "Here we are now... ");
while ( 1 )
{
    read(0, &buf, 1uLL);
    if ( v3[10] != buf )
        break;
    if ( --v3 == (__int64)"SUNIATRETNE"-1)
    {
        read(0, &buf, 1uLL);
        admin_enabled = 1;
        return __readfsqword(0x28u) ^ v5;
    }
}
```

On to the next function ...
```c
unsigned __int64 select_bear()
{
  unsigned int v1; // [rsp+4h] [rbp-14h]
  unsigned __int64 v2; // [rsp+8h] [rbp-10h]

  v2 = __readfsqword(0x28u);
  v1 = 0;
  _printf_chk(1LL, "Selection: ");
  _isoc99_scanf("%d", &v1);
  if ( (v1 & 0x80000000) == 0 && v1 < *num_bears )
    selected_bear = (void *)bears[v1];
  else
    puts("Not enough bears.");
  return __readfsqword(0x28u) ^ v2;
}
```
The program reads in a number, lets say ```a```. If it is not negative and if it is lesser than num_bears, selected_bear will now have a copy of the pointer to the bear at index ```a```. Else, it prints out "Not enough bears".

> ```(v1 & 0x800000000)==0``` means ```first bit of v1 == 0```, and the first bit of a integer is its sign bit, according to 2s complement notation.

```c
int delete_bear()
{
  if ( !selected_bear )
    return puts("No bear selected!");
  _printf_chk(1LL, "Deleting [%s]...\n");
  if ( (void (**)(void *))selected_bear->free_function == &free )
    free(selected_bear);
  return puts("Deleted!");
}
```

The function ```free()'s``` the pointer in ```selected_bear```, as long as the ```free_function``` still points to free.

> The ```selected_bear``` is not zero'ed out.
> <br>The ```bears[idx]``` is not zero'ed out.
> <br>**This challenge is a typical UAF challenge.**
> <br>```num_bears``` is not decremented

```c
int print_bear()
{
  __int64 v0; // rdx
  __int64 v1; // rdx

  if ( !selected_bear )
    return puts("No bear selected!");
  puts(art);
  _printf_chk(1LL, "You have selected: [%s]\n");
  v0 = (unsigned int)selected_bear->id;
  _printf_chk(1LL, "It's ID is %x\n");
  v1 = (unsigned int)selected_bear->age;
  _printf_chk(1LL, "It's AGE is %d\n");
  return _printf_chk(1LL, "It's DESCRIPTION is %s\n");
}
```
This function just prints out information about the ```selected_bear```.
```c
unsigned __int64 add_comment()
{
  unsigned int nbytes;

  _printf_chk(1LL, "How long should the comment be: ");
  _isoc99_scanf("%d", &nbytes);
  comment = calloc(nbytes + 1, 1uLL);
  _printf_chk(1LL, "Comment: ");
  read(0, comment, nbytes[0]);
  return;
}
```

Here comes the main tool to exploit the UAF vulneraribility. This function reads in a number then calls ```calloc(nbytes+1, 1)```, which is the same as ```malloc(nbytes+1)```.

> If we ```delete_bear()``` then ```add_comment()``` of size ```0xb8-1```, we can control ALL OF THE BEAR, including its ```self_destruct_device_ptr```, which will be called later on...
> <br> *Insert evil laugh here*

```c
int print_comment()
{
  int result; // eax

  if ( comment )
    result = puts((const char *)comment);
  else
    result = puts("No");
  return result;
}
```
Pretty basic, prints the comment or prints "No" if theres no comment.

```c
int destruction()
{
  int result; // eax

  if ( !admin_enabled )
    return puts("Nothing to do");
  result = (signed int)selected_bear;
  if ( selected_bear )
    result = (selected_bear->self_destruct_device_ptr)(*num_bears);
  return result;
}
```
If ```admin_enabled``` is true and ```selected_bear``` is valid,
we can execute ```selected_bear```'s ```self_destruct_device_ptr```

## Solution
As mentioned earlier, this is a typical UAF challenge. The obvious steps so far are:
1. Build Bear 
    1. Put arbitrary data
2. Select Bear
    1. Select 0
3. Delete Bear
4. Add Comment
    1. The size of the comment must be ```0xb8-1```, so that we ```calloc(0xb8,1)``` and so that it will reuse the free memory that belonged to ```bears[0]```
    2. We can send ```0xb0``` arbitrary bytes, then send our desired function pointer, let's say, ```0xcafebabe```
5. We call Build Bear 12 more times
    1. Put arbitrary data again
6. Build Bear (we already have 13 bears, this will go to the secret section now)
    1. This time, we send ```SUNIATRETNE``` in reverse, and this will set admin_enabled to 1
7. Destruction

Now the question is, what do we want to execute?

There isn't any function that can give shell, and we don't know the address of any function since it is a PIE binary anyway
```
$ checksec gruffybear
    Arch:     amd64-64-little
    RELRO:    Full RELRO
    Stack:    Canary found
    NX:       NX enabled
    PIE:      PIE enabled
    FORTIFY:  Enabled
```

Lets go hunting for a leak!

Actually thats really easy, since we are freeing a [smallbin-sized chunk (0xb8 = 184)](https://heap-exploitation.dhavalkapil.com/diving_into_glibc_heap/bins_chunks.html). If you see the structure of a free malloc_chunk in the smallbin size range, the first 8 bytes are a pointer to the smallbin, called [fd](https://heap-exploitation.dhavalkapil.com/diving_into_glibc_heap/malloc_chunk.html), which are the first 8 bytes of the bear's name.
To do this, we need to allocate another chunk first (build another bear) so that the chunk above ours is not the top chunk.

We can use ```print_bear()``` to leak this address, then call a libc function.

So now, do we call system()? We can't though, since we are passing the num_bears as its argument. Instead, we can use something called 'magic gadgets', which are places in libc we can jump to so that we can instantly get shell as long as some constraints are valid.

I use the tool ```one_gadget``` to do this.
```
$ one_gadget libc-2.23.so
0x45216	execve("/bin/sh", rsp+0x30, environ)
constraints:
  rax == NULL

0x4526a	execve("/bin/sh", rsp+0x30, environ)
constraints:
  [rsp+0x30] == NULL

0xf02a4	execve("/bin/sh", rsp+0x50, environ)
constraints:
  [rsp+0x50] == NULL

0xf1147	execve("/bin/sh", rsp+0x70, environ)
constraints:
  [rsp+0x70] == NULL
```
I chose the second last one (it was at random)

So now, our steps are as follows
1. Build Bear 
    1. Put arbitrary data
1. Build Bear 
    1. Put arbitrary data
2. Select Bear
    1. Select 0
3. Delete Bear
4. Print Bear
    1. This will give us the libc smallbin address for size 0xb8 (in the name)
    2. This address is also 0x70+__realloc_hook, which was the calculation I used
4. Add Comment
    1. The size of the comment must be ```0xb8-1```, so that we ```calloc(0xb8,1)``` and so that it will reuse the free memory that belonged to ```bears[0]```
    2. We can send ```0xb0``` arbitrary bytes, then send our desired function pointer, which is ```libc_base+0xf02a4```
    3. It only reads in 0xb7 bytes, so remember to remove the last byte from the input (its a null byte anyway)
5. We call Build Bear 11 more times
    1. Put arbitrary data again
6. Build Bear (we already have 13 bears, this will go to the secret section now)
    1. This time, we send ```SUNIATRETNE``` in reverse, and this will set admin_enabled to 1
7. Destruction

The final solution is in [here](./gruffybear.py)

