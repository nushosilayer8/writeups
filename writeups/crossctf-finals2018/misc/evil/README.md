# CrossCTF Finals 2018 : The Evilness (Misc)
### First Blood by : OSI Layer 8

>Ready for something ridiculously difficult?
>
>nc ctf.pwn.sg 4020

## Challenge
Once we connect to the address, we get:
```python
#!/usr/bin/env python
import sys
import flag
import signal
import os
import tempfile

temp_file = tempfile.NamedTemporaryFile(prefix="cartoon-",
                                        suffix=".dat",
                                        delete=True)


def handler(signum, frame):
    write("Times up!")
    temp_file.close()
    sys.exit(0)


def write(data, endl='\n'):
    sys.stdout.write(data + endl)
    sys.stdout.flush()


def readline():
    return sys.stdin.readline().strip()


def main():
    abspath = os.path.abspath(__file__)
    dname = os.path.dirname(abspath)
    os.chdir(dname)
    signal.signal(signal.SIGALRM, handler)
    signal.alarm(10)

    # Write the flag to the temp file
    temp_file.file.write(flag.flag)
    temp_file.file.flush()

    # Oh I'm sorry, did you want this?
    del flag.flag

    write(open(__file__).read())

    command = "/usr/bin/shred " + temp_file.name
    write("Here comes the shredder! (%s)" % command)

    ######################################################################
    #
    # INCOMING TRANSMISSION...
    #
    # CAREFUL AGENT. WE DO NOT HAVE MUCH TIME. I'VE OPENED A WORMHOLE IN
    # THE FABRIC OF TIME AND SPACE TO INTRODUCE A FAULT IN ONE BYTE!
    #
    # MAKE USE OF IT WISELY!
    #
    command_fault = list(command)
    index = int(readline())
    byt = int(readline(), 16)
    if (0x0 <= index < len(command_fault)):
        if (0x0 <= byt <= 0xff):
            command_fault[index] = chr(byt)
            command = "".join(command_fault)
    #
    # TRANSMISSION ENDED
    #
    ######################################################################

    # Oooh, did you want this too? Too bad it's being... shredded.
    os.system(command)


if __name__ == "__main__":
    main()

Here comes the shredder! (/usr/bin/shred /tmp/cartoon-EcqWge.dat)
```

Basically, we get to change one character in command ```/usr/bin/shred /tmp/cartoon-XXXXX.dat``` to any character we want, and the flag is stored in ```/tmp/cartoon-XXXXX.dat```

## Solution
There is a less known editor called ```ed``` on Linux systems. We can type in ```!sh``` inside the editor to drop into the shell. We can replace the letter 'h' with '&' in the command to instead run:
```
/usr/bin/sh&ed /tmp/cartoon-XXXXX.dat
```
which will run ```/usr/bin/sh``` (which doesn't exist), and then run ```ed /tmp/cartoon-XXXXX.dat```.
To replace the character, we send a index of 11, and
 I was too lazy to Ask the Oracle on how to actually use ```ed```, so I just went to shell and ran ```cat flag```

The solution script is [here]()