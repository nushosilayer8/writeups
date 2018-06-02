# BabyRSA - CrossCTF Quals 2018 (crypto)

> Each time I asked for the flag, it gets encoded through RSA. I'm lucky I kept all the values.
>
>[out.txt](./out.txt).

##Challenge
We're give a list of RSA n(modulus),e(exponent),c(ciphertext)

We notice that all the exponents are the same.

##Vulnerability

###RSA Algorithm
1. Firstly, 2 distinct primes are chosen, p and q
2. Calculate the modulus with n=pq
3. Calculate λ(n)=lcm(p-1,q-1)
4. Choose the exponent e such that `1<e<\lambda(n)` and e and n are coprime
5. Calculate d=e-1 (mod λ(n))
6. Calculate the ciphertext c with c=m<sup>e</sup> (mod n)
Decryption is done with m=c<sup>d</sup> (mod n)

###Common prime factor attack
If the random prime generator is flawed, it could produce 2 prime numbers that are the same, and the message can easily be found by calculating p and q, however, every single pair of primes is coprime.

###Low exponent attack
Another option is if c=m<sup>e</sup>, we can just calculate m=c<sup>1/e</sup> and we're done. This would require the exponent to be much smaller compared to the modulus. 

Since we're given many pairs of c,n,e, we can use the Chinese Remainder Theorem to calculate m<sup>e</sup> (mod `n1*n2*n3...`), then we can take the 257th root. **This assumes message remains the same**

###Chinese remainder theorem
Let N be the product of all the modulus

Let N<sub>i</sub>=N/n<sub>i</sub>

Find integers M<sub>i</sub> and m<sub>i</sub> such that M<sub>i</sub>N<sub>i</sub>+m<sub>i</sub>n<sub>i</sub>=1.

Now calculate C=Σc<sub>i</sub>M<sub>i</sub>M<sub>i</sub> mod N

C=c<sub>i</sub> mod n<sub>i</sub> for all i

N is now much larger than 257, so we can just take C<sup>1/e</sup> and we're done.

[exploit](./BabyRSA.py)

>Flag:`crossctf{Ha5tad_ch4ll3nGes_aRe_Gett1ng_b0riNg_n0w_Eh}`
