# CrossCTF Finals 2018 : Slowmo (Pwn)
### First Blood by : OSI Layer 8
>What is in this mysterious package?
>
>nc ctf.pwn.sg 4005
>
>Creator - amon (@nn_amon)

## Static Analysis

Run ```file slowmo```:
```
slowmo: ELF 32-bit LSB executable, ARM, EABI5 version 1 (SYSV), statically linked, for GNU/Linux 3.2.0, BuildID[sha1]=0c6352b62e9c246c5530b20dc13a5d82c60619cc, stripped
```

Running IDA Pro on the binary, I got code that I originally thought was some sort of language-specific setup code, like Go's runtime initialization. I had no idea what to do, so I went to solve other challenges.

Much later into the competition, the source code was released:
```c
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/mman.h>

int happy = 0;

void (*indirection)();

char tape[256];

void dis() {
    system("/bin/date");
}

void dos() {
    system("/bin/sh");
}

int main() {
    indirection = dis;
    char * ptr = tape + 128;
    alarm(30);
    char inst;
    while (1) {
        if (happy) {
            for (int i = 0; i < 256; i++) {
                printf("/%02x", tape[i]);
            }
            printf("/\n");
        }
        read(0, &inst, 1);
        switch (inst) {
            case '<':
                ++ptr;
                break;
            case '>':
                --ptr;
                break;
            case '^':
                *ptr += 1;
                break;
            case 'v':
                *ptr -= 1;
                break;
            case '!':
                indirection();
                return 0;
            case '`':
                happy = 1;
        }
    }
}
```
I actually had this function in IDA Pro's analysis, but I thought it was some junk:
```c
int __fastcall sub_105EC(int a1, int a2)
{
  unsigned int v2; // r0
  int result; // r0
  unsigned __int8 v4; // [sp+3h] [bp-11h]
  _BYTE *v5; // [sp+4h] [bp-10h]
  int v6; // [sp+8h] [bp-Ch]
  int v7; // [sp+Ch] [bp-8h]

  v7 = dword_97F8C;
  dword_99EBC = (int (__fastcall *)(_DWORD))sub_105B4;
  v5 = &unk_99E3C;
  sub_279F8(30, a2, (int)sub_105B4, &unk_99E3C);
  while ( 1 )
  {
    while ( 1 )
    {
      while ( 1 )
      {
        if ( dword_98EEC )
        {
          v6 = 0;
          if ( v6 <= 255 )
            printf("/%02x", byte_99DBC[v6]);
          sub_17E30();
        }
        v2 = sub_28620(0, &v4, (void *)1, &v4);
        if ( v4 != '>' )
          break;
        --v5;
      }
      if ( (signed int)v4 <= 62 )
        break;
      switch ( v4 )
      {
        case 0x60u:
          dword_98EEC = 1;
          break;
        case 0x76u:
          --*v5;
          break;
        case 0x5Eu:
          ++*v5;
          break;
      }
    }
    if ( v4 == 33 )
      break;
    if ( v4 == 60 )
      ++v5;
  }
  dword_99EBC(v2);
  result = 0;
  if ( v7 != dword_97F8C )
    sub_2AB9C(0);
  return result;
}
```
~~This was where I realised that I hate stripping~~.
Oh well, time to solve.

We can see that we can manipulate where ```ptr``` points to and decrement/increment the byte pointed by it. The solution is rather obvious.

The ```ptr``` originally points to ```tape+128```

## Solution
Right after the ```tape[256]``` array is the ```indirection``` function pointer (in terms of program memory).
So we move the pointer by 128 again (send '<' 128 times).

Then increment/decrement the bytes of the function pointer ```indirection``` till it points to ```dos``` instead of ```dis```(send 'v' or '^' abs(```address of dos``` - ```address of dis```) number of times, use '^' if ```dos``` is after ```dis``` or 'v' otherwise)

Call ```indirection()``` (send '!') and we get shell.

> How do find where ```dos()``` and ```dis()``` are located? The binary is stripped after all.

Well, function names are stripped, but strings are not obfuscated. But we can search for '/bin/date' and '/bin/sh', then find references to these strings.
```
.rodata:00071E9C aBinDate        DCB "/bin/date",0       ; DATA XREF: sub_105B4+8↑o
.rodata:00071E9C                                         ; .text:off_105CC↑o
.rodata:00071EA6                 ALIGN 4
.rodata:00071EA8 aBinSh_0        DCB "/bin/sh",0         ; DATA XREF: .text:000105D8↑o
.rodata:00071EA8                                         ; .text:off_105E8↑o
```

Next, we see what are the starting addresses of these functions:
```
.text:000105B4 sub_105B4                               ; DATA XREF: sub_105EC+1C↓o
.text:000105B4                                         ; .text:off_10778↓o
.text:000105B4                 STMFD   SP!, {R11,LR}
.text:000105B8                 ADD     R11, SP, #4
.text:000105BC                 LDR     R0, =aBinDate   ; "/bin/date"
.text:000105C0                 BL      sub_17428
.text:000105C4                 NOP
.text:000105C8                 LDMFD   SP!, {R11,PC}
.text:000105C8 ; End of function sub_105B4
.text:000105C8
.text:000105C8 ; ---------------------------------------------------------------------------
.text:000105CC off_105CC       DCD aBinDate            ; DATA XREF: sub_105B4+8↑r
.text:000105CC                                         ; "/bin/date"
.text:000105D0 ; ---------------------------------------------------------------------------
.text:000105D0                 STMFD   SP!, {R11,LR}
.text:000105D4                 ADD     R11, SP, #4
.text:000105D8                 LDR     R0, =aBinSh_0   ; "/bin/sh"
.text:000105DC                 BL      sub_17428
.text:000105E0                 NOP
.text:000105E4                 LDMFD   SP!, {R11,PC}
.text:000105E4 ; ---------------------------------------------------------------------------
.text:000105E8 off_105E8       DCD aBinSh_0            ; DATA XREF: .text:000105D8↑r
.text:000105E8                                         ; "/bin/sh"
.text:000105EC
```

ARM functions (usually) begin with STMFD instructions, so we can ascertain that ```dis()``` is at ```0xB4``` while ```dos()``` is at ```0xD0```.

Our solution is now:
1. Send < a total of 128 times
2. Send ^ a total of (0xD0-0xB4) times
3. Send !
4. Profit

The solution script is [here](./slowmo.py)