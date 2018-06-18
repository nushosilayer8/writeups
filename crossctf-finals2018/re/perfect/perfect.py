import random
from pwn import *

nums=[107, 127, 521, 521, 607, 1279]

def perfectexp(p): return (2**(p-1))*(2**p-1)

def run(x):
    random.seed(perfectexp(x))
    k = "".join([chr(random.randint(0, 255)) for i in range(35)])
    print(xor(k, '754e26ccd4b1bfafb3ffbdaa748780b7f0e0c3ae9acc3c008670f0fafd34f8ffa596db'.decode('hex')))

for i in nums:
    run(i)