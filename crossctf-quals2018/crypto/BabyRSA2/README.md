# BabyRSA2 - CrossCTF Quals 2018 (crypto)

> Each time I asked for the flag, it gets encoded through RSA.... again... I'm lucky I kept all the values... AGAIN!
>
>[out.txt](./out.txt).

## Challenge
We're give a list of RSA n(modulus),e(exponent),c(ciphertext)

We notice that all the modulus are the same.

## Vulnerability

### RSA Algorithm
1. Firstly, 2 distinct primes are chosen, p and q
2. Calculate the modulus with n=pq
3. Calculate λ(n)=lcm(p-1,q-1)
4. Choose the exponent e such that 1<e<λ(n) and e and n are coprime
5. Calculate d=e-1 (mod λ(n))
6. Calculate the ciphertext c with c=m<sup>e</sup> (mod n)
Decryption is done with m=c<sup>d</sup> (mod n)

### Common modulus attack
Since pq mod n=(p mod n)(q mod n)mod n and m<sup>a</sup> m<sup>b</sup>=m<sup>ab</sup>, if we can find numbers x<sub>1</sub>x<sub>2</sub>... such that Σx<sub>i</sub>e<sub>i</sub>=1, then we can calculate m<sup>1</sup>, assuming all the messages are the same.

Bézout's identity states that if x and y are coprime, then integers a,b exists such that ax+by=1, however, all our exponents share common prime factors, even any 4 exponents share a common factor. However, all 5 exponents do not share a common factor, thus, it is possible to find x<sub>1</sub>x<sub>2</sub>... such that Σx<sub>i</sub>e<sub>i</sub>=1.

We can use the extended Euclidean algorithm, however, the numbers resulting from it could be pretty huge, so the equation is evaluated by Mathematica, giving us x=[3239,237,735,556,-6676]. For negative numbers, we can calculate the inverse modulo pretty quickly, and evaluating Πm<sup>x<sub>i</sub>e<sub>i</sup> (mod n) gives us the flag.

[exploit](./BabyRSA2.py)

>Flag:`crossctf{RSA_Challenges_Are_Too_Easy}`
