import gmpy2
from Crypto.Util.number import long_to_bytes
s=open('out.txt').read().split('\n')
i=0
n=int(s[0].split(' ')[2])
c=[]
e=[]
for i in range(len(s)):
    if i%4==1:
        c.append(int(s[i].split(' ')[2]))
    elif i%4==2:
        e.append(int(s[i].split(' ')[2]))
    i+=1
num=len(c)
#Computed with mathematica
x=[3239,237,735,556,-6676]
for i in range(num):
	if x[i]<0:
        	c[i]=gmpy2.invert(c[i],n)
        	x[i]=-x[i]
msg=1;
for i in range(num):
	msg*=(pow(c[i],x[i],n))
	msg=msg%n
print(long_to_bytes(msg))
