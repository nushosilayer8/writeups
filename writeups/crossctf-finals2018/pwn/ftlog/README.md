# CrossCTF Finals 2018 : FTLOG (Pwn)
### First Blood by : OSI Layer 8
>https://youtu.be/RW2vXFLXtps
>
>nc ctf.pwn.sg 4004
>
>Hint: The raspberry Pis might come in handy but you can look at using qemu too.
>
>Creator - amon (@nn_amon)

## Static Analysis
Running ```file ftlog``` gives:
```
ftlog: ELF 32-bit LSB executable, ARM, EABI5 version 1 (SYSV), statically linked, for GNU/Linux 3.2.0, BuildID[sha1]=c3d8b29303d27686f7190bf2e3d88fc857517a3b, not stripped
```

The binary is ARM, so I expected it to be hard to run/debug the program locally. [Luckily, pwntools can emulate other architectures using qemu](http://docs.pwntools.com/en/stable/qemu.html), so at the very least we can run the challenge locally.

The code for the challenge is as follows:
```c
int __cdecl main(int argc, const char **argv, const char **envp)
{
  void (__fastcall *v3)(int); // ST00_4
  int v4; // r0

  puts(&art, argv, envp);
  v3 = (void (__fastcall *)(int))malloc(512);
  mprotect(v3, 512, 7);
  v4 = read(0, v3, 512);
  v3(v4);
  return 0;
}
```

The prints out some _art_, then allocates memory and marks it as 
executable (```mprotect(v3, 512, 7)``` => ```mprotect(memory, memory_size, PROT_READ | PROT_WRITE | PROT_EXEC)```). Then, it reads in some input to the memory and executes our input.
In other words, this is a simple shellcode challenge, but for ARM.

## Solution

The solution is to simply send in some ARM shellcode to spawn shell, then interact with it.

Solution code in [here](ftlog.py)

P.S. I still have no idea what the YouTube link is for
