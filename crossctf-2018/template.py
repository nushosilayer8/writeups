from pwn import *

libc_path = 'libc.so.6'
if args.REMOTE:
    p = remote('host', port)
else:
    p = process('./<name>', env={'LD_PRELOAD':  os.path.join(os.getcwd(), libc_path)})
    
libc = ELF(libc_path)


