from pwn import *
import base64

HOST = 'ctf.pwn.sg'
PORT = 1401

message = '\xff' * 14160

def and_strings(s1, s2):
	return ''.join([chr(ord(s1[i]) & ord(s2[i])) for i in range(len(s1))])

for i in range(500):
	print i
	r = remote(HOST, PORT)
	m = base64.b64decode(r.readall().strip().encode('utf-8'))
	assert len(m) == 14160
	message = and_strings(message, m)

open('flag', 'w').write(message)