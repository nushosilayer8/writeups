# LossyORacle - CrossCTF Quals 2018 (crypto)

> No one believes I can recover the message from this crappy ORacle.
> nc ctf.pwn.sg 1401
> Creator - prokarius (@prokarius)


## Challenge
We are given a service that runs the python script [lossyoracle.py](https://raw.githubusercontent.com/nush-osi-layer-8/writeups/master/crossctf-quals2018/crypto/lossyoracle/lossyoracle.py). We can connect to the service using `nc` and it will spit out the encrypted flag.

The script reads the flag file, then encrypts it with a key using the following function.

```
def encrypt(data, key, func):
    length = len(key)
    output = []
    for i in range(len(data)):
        output.append(func(data[i],key[i%length]))
    return bytes(output)
```

From the following code, we notice that `func` over here is just a bitwise OR (\|) operation applied to each byte in the flag with the key.

```
function = [lambda x,y:x&y, lambda x,y:x|y]
print (base64.b64encode(encrypt(data, key, function[1])).decode("utf-8"))
```

One problematic thing is, the key is always random. Not only that the bytes in the key are random every time, but the length of the key is also random every time!

```
key = []
for i in range(random.randrange(64,128)):
    key.append(random.randrange(0,255))
key = bytes(key)
```

## Vulnerability
Or maybe it is not problematic for us, but a helpful vulnerability instead.

For the following, we will refer to ON as a bit being equal to 1, while OFF as a bit being equal to 0.

### Bitwise OR
The property of a bitwise OR operation is that bits that are ON (equal to 1) will always stay ON, no matter what the bit is ORed with.

This means, for each byte in the flag, for every single bit in them, as long as they are ON, no matter what key is used, they will always be ON after encryption.
On the other hand, for bits in the flag that are OFF, sometimes, since the key is randomly generated, they may end up still being OFF after encryption.

This means, we can take a lot different ciphertexts, and in at least one of them, the bits that are supposed to be OFF in the original flag must be OFF, since they definitely can't be ON forever, considering we are using a randomly generated key. 

### Bitwise AND
Now, the property of a bitwise AND operation is that bits that are OFF (equal to 0) will always stay OFF, no matter what the bit is ANDed with.
So, we can just apply the bitwise AND operation on many different ciphertexts together. 

How this works is that bits that are ON in the flag are ON forever regardless of the key, so even after applying bitwise AND on so many different ciphertexts they will still be ON.

On the other hand, if we have many different ciphertexts, there must be at least one occurence where a bit that is originally OFF stays OFF, as the corresponding part of the key encrypting it may be OFF as well. By applying bitwise AND on all the ciphertexts together, this bit will be turned OFF.

So, the final result would be a set of bytes, which has the same bits as the flag that are ON, and the same bits that are OFF, which is the flag!

## Exploit
### Get many ciphertexts
First thing we need is to automate the process of getting ciphertexts since we need A LOT of them.

We can easily do it using pwntools.

```
from pwn import *
import base64

HOST = 'ctf.pwn.sg'
PORT = 1401

r = remote(HOST, PORT)
m = base64.b64decode(r.readall().strip().encode('utf-8'))
assert len(m) == 14160
```

Along the way, we also convert the message to the correct encoding, and add a safety check to make sure the number of bytes received is always the same.

### AND them all!
We can write a simple python function to do the bitwise AND between two strings for us. We initialize message to be a bunch of `\xff` bytes, which means all bits in it are ON at the start.
```
message = '\xff' * 14160

def and_strings(s1, s2):
	return ''.join([chr(ord(s1[i]) & ord(s2[i])) for i in range(len(s1))])
```


### Combining all together
Our final solution is

```
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
```

At first, I tried to read the flag on the terminal, but I get a bunch of unreadable bytes. I was confused and doubted my solution. But then, I remembered it was 14kb of data, sounds more likely to be a file.

So, `open('flag', 'w').write(message)` was added to save the decrypted flag in a file.

## Reading the flag
While doing `file flag`, I get
```
flag: MPEG ADTS, layer III, v2,  16 kbps, 24 kHz, Monaural
```

A MPEG file! Play it using `mpg123 flag` and we get the flag!