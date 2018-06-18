# CrossCTF Finals 2018 : BabyRSA3 (crypto)

> So I heard that you can flip the private and public information for RSA...
> 
> Creator - prokarius (@prokarius)

We are given a file [outNerfed.txt](./outNerfed.txt), which contains `c`, the ciphertext, `d`, the private exponent and `phi(n)`, which is equal to `(p-1)(q-1)`.

## Challenge
To decrypt the ciphertext, we will need `d` and `n`. So the challenge here is to find a way to get `n` from `phi(n)`.

## Solution
### Factorization
To get `n` from `phi(n)`, the most sensical step is to find `p-1` and `q-1`, so that we can find `n=pq`. We tried to use [yafu](https://sourceforge.net/projects/yafu/) to do it, and it worked very nicely.

```
 daniel@daniel  ~/Downloads/yafu  ./yafu 'factor(25744472610420721576721354142700666534585707423276540379553111662924462766649397845238736588395849560582824664399879219093936415146333463826035714360316647265405615591383999147878527778914526369981160444050742606139799706884875928674153255909145624833489266194817757115584913491575124670523917871310421296173148930930573096639196103714702234087492)'


fac: factoring 25744472610420721576721354142700666534585707423276540379553111662924462766649397845238736588395849560582824664399879219093936415146333463826035714360316647265405615591383999147878527778914526369981160444050742606139799706884875928674153255909145624833489266194817757115584913491575124670523917871310421296173148930930573096639196103714702234087492
fac: using pretesting plan: normal
fac: no tune info: using qs/gnfs crossover of 95 digits
div: primes less than 10000
fmt: 1000000 iterations
rho: x^2 + 3, starting 1000 iterations on C346 
rho: x^2 + 2, starting 1000 iterations on C346 
rho: x^2 + 1, starting 1000 iterations on C346 
pm1: starting B1 = 150K, B2 = gmp-ecm default on C346
ecm: 0/30 curves on C334, B1=2K, B2=gmp-ecm default
ecm: 0/29 curves on C322, B1=2K, B2=gmp-ecm default
ecm: 0/28 curves on C310, B1=2K, B2=gmp-ecm default
ecm: 0/27 curves on C272, B1=2K, B2=gmp-ecm default
ecm: 0/26 curves on C259, B1=2K, B2=gmp-ecm default
ecm: 1/25 curves on C246, B1=2K, B2=gmp-ecm default
ecm: 0/23 curves on C221, B1=2K, B2=gmp-ecm default
ecm: 1/22 curves on C196, B1=2K, B2=gmp-ecm default
ecm: 1/20 curves on C183, B1=2K, B2=gmp-ecm default
ecm: 0/18 curves on C170, B1=2K, B2=gmp-ecm default
ecm: 2/17 curves on C157, B1=2K, B2=gmp-ecm default
ecm: 3/14 curves on C144, B1=2K, B2=gmp-ecm default
ecm: 1/10 curves on C132, B1=2K, B2=gmp-ecm default
ecm: 8/8 curves on C119, B1=2K, B2=gmp-ecm default
ecm: 3/74 curves on C119, B1=11K, B2=gmp-ecm default
fac: factoring 48636585985082768736526784024200750021
fac: using pretesting plan: normal
fac: no tune info: using qs/gnfs crossover of 95 digits
div: primes less than 10000
fmt: 1000000 iterations
rho: x^2 + 3, starting 1000 iterations on C38 
rho: x^2 + 2, starting 1000 iterations on C38 
rho: x^2 + 1, starting 1000 iterations on C38 
pm1: starting B1 = 150K, B2 = gmp-ecm default on C38
ecm: 0/30 curves on C38, B1=2K, B2=gmp-ecm default
ecm: 0/29 curves on C26, B1=2K, B2=gmp-ecm default
Total factoring time = 0.1867 seconds
fac: factoring 52537838568268884632273629
fac: using pretesting plan: normal
fac: no tune info: using qs/gnfs crossover of 95 digits
div: primes less than 10000
fmt: 1000000 iterations
rho: x^2 + 3, starting 1000 iterations on C26 
rho: x^2 + 2, starting 1000 iterations on C26 
rho: x^2 + 1, starting 1000 iterations on C26 
pm1: starting B1 = 150K, B2 = gmp-ecm default on C26
ecm: 1/30 curves on C26, B1=2K, B2=gmp-ecm default
Total factoring time = 0.2959 seconds
fac: factoring 9434943930960179869296047
fac: using pretesting plan: normal
fac: no tune info: using qs/gnfs crossover of 95 digits
div: primes less than 10000
fmt: 1000000 iterations
rho: x^2 + 3, starting 1000 iterations on C25 
rho: x^2 + 2, starting 1000 iterations on C25 
rho: x^2 + 1, starting 1000 iterations on C25 
pm1: starting B1 = 150K, B2 = gmp-ecm default on C25
ecm: 1/30 curves on C25, B1=2K, B2=gmp-ecm default
Total factoring time = 0.2060 seconds
Total factoring time = 4.6255 seconds


***factors found***

P1 = 2
P1 = 2
P13 = 2767687179787
P12 = 333600482773
P13 = 6938103821809
P13 = 3680247726403
P13 = 8313722160551
P13 = 6438418759151
P13 = 6545600536253
P13 = 6672422609813
P13 = 6579600728639
P13 = 3639128890921
P13 = 9566431650679
P13 = 9220079755217
P106 = 2293498615990071511610820895302086940796564989168281123737588839386922876088484808070018553110125686555051
P13 = 4065711354007
P13 = 1973804930501
P13 = 6060693342503
P13 = 7265658595571
P13 = 7230980905199
P13 = 4754509728797
P13 = 1984419944251

ans = 1
```

Cleaning up the output, and putting them into a python script

```
a = []
a.append(2)
a.append(2)
a.append(2767687179787)
a.append(7230980905199)
a.append(3680247726403)
a.append(7265658595571)
a.append(6545600536253)
a.append(6579600728639)
a.append(3639128890921)
a.append(333600482773)
a.append(9220079755217)
a.append(8313722160551)
a.append(9566431650679)
a.append(6938103821809)
a.append(6438418759151)
a.append(2293498615990071511610820895302086940796564989168281123737588839386922876088484808070018553110125686555051)
a.append(4754509728797)
a.append(6672422609813)
a.append(1973804930501)
a.append(6060693342503)
a.append(1984419944251)
a.append(4065711354007)

c = 5499541793182458916572235549176816842668241174266452504513113060755436878677967801073969318886578771261808846567771826513941339489235903308596884669082743082338194484742630141310604711117885643229642732544775605225440292634865971099525895746978617397424574658645139588374017720075991171820873126258830306451326541384750806605195470098194462985494
d = 15664449102383123741256492823637853135125214807384742239549570131336662433268993001893338579081447660916548171028888182200587902832321164315176336792229529488626556438838274357507327295590873540152237706572328731885382033467068457038670389341764040515475556103158917133155868200492242619473451848383350924192696773958592530565397202086200003936447
phi = 25744472610420721576721354142700666534585707423276540379553111662924462766649397845238736588395849560582824664399879219093936415146333463826035714360316647265405615591383999147878527778914526369981160444050742606139799706884875928674153255909145624833489266194817757115584913491575124670523917871310421296173148930930573096639196103714702234087492
```

### Find n
Now, we just need to split the factors into 2 sets, satisfying the condition that the product of the integers in each set, added by 1, will be a prime number. 

In other words, split the factors we got into `p-1` and `q-1`, while making sure that `p` and `q` are both prime.

To do so, we can use `itertools.combinations` to generate different combinations of factors, and check if they fit the conditions above. Once we managed to find the `p` and `q` we need, all we need is to do left is find `m = c ^ d % n`.

```
import itertools
import gmpy2

def P(a):
	return reduce(lambda x, y: x*y, a)

for n in range(1, 12):
	for i in itertools.combinations(a, n):
		// check if p and q are prime
		if (gmpy2.is_prime(P(i) + 1)) and gmpy2.is_prime(phi / P(i) + 1):
			p = P(i) + 1
			q = phi / P(i) + 1

			// found n, decrypt the ciphertext
			n = p * q
			plain = gmpy2.powmod(c, d, n)
			print hex(plain)[2:].decode('hex')
			exit()
```