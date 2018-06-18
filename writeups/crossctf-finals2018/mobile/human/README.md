# CrossCTF Finals 2018 : Human Powered Flag Generator
### First Blood by : Segfaulters

>Keep cranking until the whole flag appears!
>
>Creator - prokarius (@prokarius)

## Static Analysis
We are given an APK file, which upon extracting and converting to its Java code, we get:
```java
package com.a2018.crossctf.humanpoweredflaggenerator;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView flagDisplay;
    private TextView percent;
    private Status status;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0185R.layout.activity_main);
        this.status = new Status();
        this.flagDisplay = (TextView) findViewById(C0185R.id.flagTextView);
        this.percent = (TextView) findViewById(C0185R.id.percentTextView);
        findViewById(C0185R.id.speedupButton).setOnClickListener(new MainActivity$$Lambda$0(this));
        findViewById(C0185R.id.crankButton).setOnClickListener(new MainActivity$$Lambda$1(this));
    }

    final /* synthetic */ void lambda$onCreate$0$MainActivity(View view) {
        this.status.speedUp();
    }

    final /* synthetic */ void lambda$onCreate$1$MainActivity(View view) {
        crank();
    }

    private void crank() {
        this.status.crank(3.8d);
        Resources res = getResources();
        this.flagDisplay.setText(res.getString(C0185R.string.flag, new Object[]{this.status.flag()}));
        this.percent.setText(res.getString(C0185R.string.percent, new Object[]{Integer.valueOf(this.status.level()), this.status.percent()}));
    }
}

```
Seems like the app has a display for the flag, a display for percent of work done, and a button to 'work' to flag generation, and a button to speed up the process.
```java
package com.a2018.crossctf.humanpoweredflaggenerator;

import android.annotation.SuppressLint;
import java.math.BigInteger;

class Status {
    private BigInteger curr;
    private BigInteger f9f;
    private StringBuilder flagBuilder = new StringBuilder();
    private BigInteger fmax;
    private int level = 0;
    private BigInteger max;
    private BigInteger prod;

    Status() {
        upLevel();
    }

    public void crank(double am) {
        double amount = Math.pow(am, (double) this.level);
        for (int i = 0; ((double) i) < amount; i++) {
            if (this.max.compareTo(this.curr) == 0) {
                if (this.level != 13) {
                    this.flagBuilder.append(extract());
                    upLevel();
                } else {
                    return;
                }
            } else if (this.f9f.compareTo(this.fmax) == 0) {
                this.curr = this.curr.add(BigInteger.ONE);
                upF();
            } else {
                this.prod = this.prod.multiply(this.f9f);
                this.f9f = this.f9f.add(BigInteger.ONE);
            }
        }
    }

    public String flag() {
        return this.flagBuilder.toString();
    }

    public int level() {
        return this.level;
    }

    @SuppressLint({"DefaultLocale"})
    public String percent() {
        double frac = BigInteger.valueOf(10000).divide(this.max.subtract(BigInteger.ONE)).doubleValue();
        double x = this.curr.doubleValue() - 1.0d;
        return String.format("%.2f", new Object[]{Double.valueOf(Math.min(100.0d, (((BigInteger.valueOf(10000).multiply(this.f9f).divide(this.fmax).doubleValue() / 10000.0d) + x) * frac) / 100.0d))});
    }

    private void upLevel() {
        this.level++;
        this.max = BigInteger.ONE.shiftLeft(this.level).add(BigInteger.ONE);
        this.curr = BigInteger.ONE;
        this.prod = BigInteger.ONE;
        upF();
    }

    private void upF() {
        this.fmax = fastExpo(BigInteger.valueOf(5), this.curr).add(BigInteger.ONE);
        this.f9f = BigInteger.ONE;
    }

    public void speedUp() {
        while (this.prod.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            this.prod = this.prod.divide(BigInteger.TEN);
        }
    }

    private String extract() {
        BigInteger thousand = BigInteger.valueOf(1000);
        speedUp();
        return this.prod.mod(thousand).add(thousand).toString().substring(1);
    }

    private static BigInteger fastExpo(BigInteger x, BigInteger y) {
        BigInteger out = BigInteger.ONE;
        while (y.compareTo(BigInteger.ONE) != 0) {
            if (y.and(BigInteger.ONE).equals(BigInteger.ONE)) {
                out = out.multiply(x);
            }
            x = x.multiply(x);
            y = y.shiftRight(1);
        }
        return out.multiply(x);
    }
}

```
(other useless files like lambda classes/resources files filtered out)

This seems like the meat of the app. Extracting this class out and running it on my local machine using a Java IDE, it seems that it takes a ... very long time ... yea no, running it won't solve the problem.

The ```flagBuilder``` is a StringBuilder containing the flag. I started out by combining the methods together so to form as few methods as possible, then I converted this to Python so that my eyes don't bleed from the verbosity of Java.

```python
class Status:
    __init__():
        level=1
        max = 3
        curr = 1
        prod =1
        fmax = 6
        f9f = 1
        flag = ''

    def crank(am):
        amount = am**level;
        for i in range(amount):
            if max == curr 
                if level == 13:
                    return
                while prod%10==0:
                    prod//=10
                flag += str((prod%1000)+1000)[1:]
                level++
                max = 1<<level +1
                curr = 1
                prod = 1
                fmax = 6
                f9f = 1
            elif f9f == fmax:
                curr++;
                fmax = (5**curr) + 1
                f9f = 1
            else:
                prod *= f9f;
                f9f++;
```

The entire class can be replaced by just the crank method, as long as the state is stored within the function itself. We will do that, and things should get a lot simpler. The ```crank()``` code still looks really bad, so we can begin by simplifying the code. The code looks suspiciously like disassembled nested while loops, so I started with that concept, then made ```crank()``` return the flag instead of just shoving into a variable.

```python
def crank():
    flag = ''
    for level in range(1,13):
        prod=1
        for curr in range(1, (1<<level)+1):
            fmax = 5**curr+1
            for f9f in range(fmax)
                prod *= f9f
    while prod % 10 == 0:
        prod = prod // 10
    flag+= str(prod%1000).rjust(3,'0')
    return flag
```

The innermost for loop can be simplified, so the code can be:
```python
def crank():
    flag = ''
    for level in range(1,13):
        prod=1
        for curr in range(1, (1<<level)+1):
            prod *= factorial(curr)
    while prod % 10 == 0:
        prod = prod // 10
    flag+= str(prod%1000).rjust(3,'0')
    return flag
```
where ```factorial``` is the  factorial function, which I created to be a simple for-loop instead of recursion (python and its stack ;-;).

That's not the real problem of course. It took wayyyy to long.

Of course, it's because we are going to call factorial(5**(1<<level)), which will take toooooo long.

I was going to use Wolfram Alpha's API to get the factorial of those large numbers, when I realised there was a pattern in the factorials of (5\**i): the last 3 digits are repeating (984, 088, 016, 912), except for factorial(5\**1) which is 120.

Since the flag only cares about the last 3 digits of prod, which is the multiplication of all factorials of (5\**i) in the range [1 to 1<<level], we can replace the factorial function with one that gives only the last 3 digits:
```python
def factorial(g):
    if g == 1:
        return 120
    else:
        return [984, 88, 16, 912][(g-2)%4]
```

The final code is in [here](./human.py)