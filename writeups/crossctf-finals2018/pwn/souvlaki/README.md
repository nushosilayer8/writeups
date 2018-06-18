# CrossCTF Finals 2018 : Souvlaki Space Station (Pwn)
### First Blood by : OSI Layer 8

>Pictures and I've fallen Wonder why I'm here now
>
>nc ctf.pwn.sg 4006
>
>Creator - amon (@nn_amon)
>
>Hint: Try examining the use of 'strlen()' and 'signal()'.

## Static Analysis

~~Well what do you know, I'm really starting to hate ARM~~

Static analysis using IDA just fails. The printed code was 5 lines long and the function calls did not match what was actually being called in the function at runtime. Viewing the function in graph mode, there are pieces of code that IDA just didn't detect as part of the control flow graph, and goofed up.

I was determined to actually learn ARM assembly in the last 8 hours or so, but luckily the source was released soon after ;)

```c
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <signal.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>

typedef struct state {
    int admin;
    char message[128];
    char * presenter;
    size_t length;
} state;

state global_state;

void sighandler(int signum)
{
    signal(signum, SIG_DFL);
    puts("souvlaki.c:10:5: warning: implicit declaration of function ‘exit’ [-Wimplicit-function-declaration]");
    puts("     exit(1);");
    puts("souvlaki.c:10:5: warning: incompatible implicit declaration of built-in function ‘exit’");
    puts("souvlaki.c:10:5: note: include ‘<stdlib.h>’ or provide a declaration of ‘exit’");
    if (global_state.admin) {
        puts("To report this bug, please contact support@linux.org.");
        execl("/usr/bin/vi", NULL);
    }
    exit(1);
}

void init() {
    global_state.admin = 0;
    strcpy(global_state.message, "P L A C E H O L D E R  T E X T  M A N");
    global_state.presenter = "[EC2 (%lld/150)]: ";
    global_state.length = strlen(global_state.message) + 1;
}

int main()
{
    state * ptr = &global_state;
    ++ptr;
    --ptr;
    init();

    // Disable buffering on stdin, stdout, and stderr
    setvbuf(stdin, NULL, _IONBF, 0);
    setvbuf(stdout, NULL, _IONBF, 0);
    setvbuf(stderr, NULL, _IONBF, 0);

    signal(SIGSEGV, sighandler);
    uint64_t count = 1;

    while (count <= 150) {
        printf(global_state.presenter, count);
        read(0, global_state.message, global_state.length);
        global_state.length = strlen(global_state.message) + 1;
        for (int i = 0; i < global_state.length; i++) {
            if (global_state.message[i] == '\n') {
                global_state.message[i] = 0;
            }
        }
        for (int i = 0 ; i < global_state.length; i++) {
            printf("%hhd ", global_state.message[i]);
        }
        puts("");
        ++count;
    }

    return 0;
}
```

We have a signal handler set for ```SIGSEGV```, segmentation fault, that runs ```vi```. You can actually get shell from ```vi``` by going to command mode (type ```:```), then entering ```!sh```. Of couse, you need to set ```global_state.admin``` to a non-zero value first.

There's a very subtle bug in the while loop in main().
From these:
```c
read(0, global_state.message, global_state.length);
global_state.length = strlen(global_state.message) + 1;
```
We can see that ```global_state.length``` is _intended_ to be used as the actual string length in ```read()```, but we set it to actual string length (of the message) + 1 in the next line.

Thus, we can increase ```global_state.length``` by 1 if we fill up the ```global_state.message``` (send 'a' * the current ```global_state.length```).

## Solution
If we can fill the entire 128 bytes of ```global_state.message``` (and make sure not to send any '\n'), ```strlen(global_state.message)``` will actually give us ```128 + number of non-zero bytes of global_state.presenter```. Thus, we can edit the value of ```global_state.presenter``` as long as the value we want to write isn't too big. Note that 37 bytes are already filled with a pre-existing message.

If we change it to the address of our input, we can try to do a format string attack, since ```global_state.presenter``` is used as the formatting argument to printf.

Luckily, PIE isn't enabled, and the ```global_state``` is stored in the .bss section, so we can write it with the address of our input, which is ```0x98ca0```

```
$ checksec souvlaki
    Arch:     arm-32-little
    RELRO:    Partial RELRO
    Stack:    No canary found
    NX:       NX enabled
    PIE:      No PIE (0x10000)
```
Now we need to set ```global_state.admin``` to a non-zero value, and then crash the program.

### Dynamic Analysis
Now, I knew very little about ARM architecture and how printf() worked with its registers and stack, so I made the input a long string of "%p ..." first.

Luckily the 7th argument printed out was the address of ```global_state.admin``` (```0x00098c9c```), and some arguments were very low values, like the 2nd argument (attempting to write to them would likely segfault).

Now, we do a typical format string attack in our input by sending "A%7$n" (the 'A' is there so that 1 byte is printed already, and %n will write 1 to the address that is the 7th argument), then just try to print to the 2nd argument using "%2$n", which will crash the program and run ```vi``` for us. We have to pad this to 128 bytes, then finally send in our input's address.

Once ```vi``` starts up, we type in ```:!sh``` to get shell


Solution code in [here](souvlaki.py)
