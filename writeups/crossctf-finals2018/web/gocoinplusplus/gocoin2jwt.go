package main

import (
	"fmt"
	"github.com/dgrijalva/jwt-go"
	"math/rand"
)

func Wallet(wallet float64, bank float64, mySigningKey []byte) (string, error) {
	token := jwt.New(jwt.GetSigningMethod("HS256"))
	claims := make(jwt.MapClaims)
	claims["wallet"] = wallet
	claims["bank"] = bank
	claims["rand"] = rand.Uint64()
	token.Claims = claims
	//key, err := jwt.ParseRSAPrivateKeyFromPEM(mySigningKey)
	tokenString, err := token.SignedString(mySigningKey)
	return tokenString, err
}

func main() {

	// sample token string taken from the New example

	myKey := `-----BEGIN PUBLIC KEY-----
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCyg+EcZOSLYXqdA0Gdx6hE0PFY
GshbSxHwBbZ0Ivw41OCD447WtiTmBKWhYkyZIW1uF2G0YpifP9CGZgIHhW6jPUwB
u1ewHy0ch+GQeMleaVGqEOsAd65DAXi2TSCZLl66zWy0enQ/SFkm9OTTGYR0e0hM
DFqKsA30lPd0pHbSNwIDAQAB
-----END PUBLIC KEY-----
`

	tokenString, err := Wallet(10000, 10000, []byte(myKey))
	fmt.Println(err)
	fmt.Println(tokenString, "token")

	// Parse takes the token string and a function for looking up the key. The latter is especially
	// useful if you use multiple keys for your application.  The standard is to use 'kid' in the
	// head of the token to identify which key to use, but the parsed token (head and claims) is provided
	// to the callback, providing flexibility.
	token, err := jwt.Parse(tokenString, func(token *jwt.Token) (interface{}, error) {
		// Don't forget to validate the alg is what you expect:
		if _, ok := token.Method.(*jwt.SigningMethodHMAC); !ok {
			fmt.Println("not hmac")
		}

		// hmacSampleSecret is a []byte containing your secret, e.g. []byte("my_secret_key")
		return []byte(myKey), nil
	})

	if claims, ok := token.Claims.(jwt.MapClaims); ok && token.Valid {
		fmt.Println(claims["wallet"], claims["bank"])
	} else {
		fmt.Println(err)
	}

}
