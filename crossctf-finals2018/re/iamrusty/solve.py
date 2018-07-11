key_index = 0
key_index2 = 0
key_schedule = map(ord, list(open('key_schedule', 'r').read()))

def get_key():
	global key_index, key_index2, key_schedule
	key_index = (key_index + 1) % 256
	key_index2 = (key_index2 + key_schedule[key_index]) % 256

	key_schedule[key_index2], key_schedule[key_index] = key_schedule[key_index], key_schedule[key_index2]
	return key_schedule[(key_schedule[key_index] + key_schedule[key_index2]) % 256]


if __name__ == '__main__':
	c = [193, 43, 110, 37, 49, 203, 177, 168, 213, 56, 111, 114, 136, 234, 91, 129, 74, 3, 134, 159, 134, 47, 53, 245, 103, 247, 251, 52, 198, 245, 208, 139, 188, 151, 208, 36, 109, 245, 48, 174, 123, 154]
	flag = ''
	for i in xrange(len(c)):
		flag += chr(c[i] ^ get_key())

	print flag

