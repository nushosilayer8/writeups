# Choose Your Own Adventure - CrossCTF Quals 2018 (misc)

> Maybe your question was too long. You *reduced* the length of your question and asked the oracle again: "Where's the flag?"
> As expected, she had no *reaction* again. You sigh... maybe the *solution* really was in there after all. You close your eyes and started willing yourself back into the enemy's base...
> Non-standard flag format: <code>[A-Z0-9]+</code>

## Challenge
We are given the hints in this format:

>01 01 02, Score: 04
>
>You contribute to the puddle of urine in the corner of this room.
>
>Scribbled into the wall is the number 17.
>
>Below in red, the number 0 was written.
>
>Where would you like to move?
>
>6 -- Down
>
>9 -- Quit

1-6 are used to navigate the location to collect all the hints.

And we are also given 4 hints to solve the challenge:
>Hint 1 for CYOA: len(flag) = 9 Think outside the box for this challenge. It's less of a ctf challenge and more of a misc puzzle tbh...
>
>Think about how the contents of each room relate to the coordinates and the score.
>
>So now that you can match why each object is in a specific room (with a certain coordinate and score), perhaps think about the scribblings. What's the meaning behind the scribbles?
>
>You are looking for a string of characters that leads to the final flag. Link each object in the rooms to the coordinates and figure out the overarching theme of the puzzle.

And the words reduced, reaction and solution are italicized, suggesting the topic is chemistry.

## Interpreting the hints

Consider the hint above, urea is one component of urine, with chemical formula CO(NH2)2 -> C1O2N2H4, which corresponds to the coordinates(01 01 02) and the score(04). With this in mind we check all the other 19 hints and get all the chemical formula.

The scribbles in the wall are also unique, ranging from 0 to 19, which suggests the chemicals can be sorted.

Scribble | Chemical | Red no.
--- | --- | ---
0 | acetone | 1
1 | acetic acid | 0
2 | propene | 0
3 | nitrous oxide | 6
4 | acetic acid | 0
5 | nitrogen | 1
6 | acetone | 1
7 | nitrogen | 1
8 | ozone | 3
9 | *null* | 0
10 | nitrogen | 1
11 | ozone | 3
12 | *null* | 0
13 | formaldehyde | 0
14 | ammonia | 3
15 | water | 4
16 | methane |0 
17 | urea | 0
18 | glycerol | 1
19 | acetic acid | 0

To solve the challenge, we take the (Red no.)th element of the chemical's common name and list them out

capsaicin in formula

>Flag: C18H27NO3
