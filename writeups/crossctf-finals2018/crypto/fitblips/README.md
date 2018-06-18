# CrossCTF Finals 2018 : fitblips (crypto)

> How many steps does your Fitblip beep?
>
> nc ctf.pwn.sg 4003
>
> Creator - amon (@nn_amon)

[server code](./server.py)

## Analysis
To summarize what this program does:

1. It reads the flag from a file, hex encodes it, and turns it into a stream of bits
2. Reads in user input, hex encodes it, and turns it into a stream of bits
3. Compares the user input and flag bit by bit, and terminates once it is different
4. Prints the time taken for comparison, plus the number of bits that matched.
5. Oops forgot to mention, it also lets the user decide how many times to run the **same** comparison.

On first sight, we can tell that this is simply just a programming challenge to do a timing attack. Except that since everyone in the competition is hitting the server it is more accurate to use the score than to use the time taken.

## Solution
Simply write a script to try strings that start exactly the same but one ending with bit 0 and one ending with bit 1.

You can find our script [here](./solve.py).

### Because why not
[![asciicast](https://asciinema.org/a/SqSll9IBu3TAXzbUlM0M935HN.png)](https://asciinema.org/a/SqSll9IBu3TAXzbUlM0M935HN?speed=5)