from Crypto.Util.number import bytes_to_long, long_to_bytes
import gmpy2
import string

#parsing input
f=open('out.txt').read().split('\n')
i=0
e=int(f[1].split(' ')[2])
n=[]
c=[]
for i in range(len(f)):
    if i%4==0:
        c.append(int(f[i].split(' ')[2]))
    elif i%4==2:
        n.append(int(f[i].split(' ')[2]))
    i+=1
num=len(n)

#chinese remainder theorem
N=1
for i in n:
    N*=i
NN=[None]*num
t=[None]*num
x = 0
for i in range(num):
    NN[i]=N//n[i]
    t[i]=gmpy2.invert(NN[i],n[i])
    x+=c[i]*t[i]*NN[i]

#flag
print(long_to_bytes(gmpy2.iroot(x%N,257)[0]))
