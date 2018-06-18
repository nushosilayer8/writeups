from z3 import *
from pwn import *

def ab2(a):
	return 0x43726f73 * a + 0x73435446

def a7f(a1, a2):
	res = 0
	for i in range(a2):
		res = ab2(res + ZeroExt(24, a1[i]))

	return Extract(15, 0, res)

def beer(s):
	return Extract(15, 0, a7f(s, len(s)))

def solve_for(value):
	for i in range(1, 1024):
		s = Solver()
		inp = []
		for j in range(i):
			inp.append(BitVec('%d.%d' % (i, j), 8))

		s.append(inp[i - 1] == 0x0a)

		outp = a7f(inp, len(inp))

		s.append(outp == value)

		s.check()

		try:
			m = s.model()
		except Exception:
			continue

		sol = []
		for j in range(i):
			sol.append(chr(m[inp[j]].as_long()))
		return ''.join(sol)

r = remote('ctf.pwn.sg', 16667) # process('./towerofbeer')
r.sendline('6')

for i in range(20):
	r.recvuntil(":P\n")
	num = int(r.recvuntil("\n").strip())

	print num
	ans = solve_for(num)
	r.send(ans)
	r.recvuntil('Your turn:')
	print r.recv()
	print r.recv()

r.interactive()