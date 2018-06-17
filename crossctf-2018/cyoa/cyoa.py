import struct

nums = [1068077148, 1805536572,1005526689, 1727990831, 1301214146, 428181300, 1107313295, 2147483648, 993912976, 778615823, 1090848777]

def tof(b):
   s = struct.pack('>L', b)
   return struct.unpack('>f', s)[0]

print([tof(x) for x in nums])
