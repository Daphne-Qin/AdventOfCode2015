# AdventOfCode2015
You are currently viewing the **AdventOfCode2015** repository.

### Basic Personal Info
**Name**: Daphne Qin\
**Class**: APCS\
**Period**: 5

## About this Repository
The original problems can be found [here](https://adventofcode.com/2015 "Advent of Code 2015"). All code found here are (in some cases, inefficient) solutions to those questions.

### About the Code
- I put my site-generated puzzle inputs either in `input.txt` or near the top of the code.
- The general syntax is `java ProblemX input.txt [1/2]`, with some exceptions:
  - Problems 10 and 20 use `java ProblemX [1/2]` since their inputs are coded into the program.
  - Problem 25 doesn't seem to have a Part 2 and thus just uses `java Problem25`.

### Longest Runtimes Hall of ~~Shame~~ Fame
*Mainly so I can laugh at myself. Note that when I timed these, I turned their progressCheck options to `true` (which prints each iteration into the console) since I wanted to make sure they were actually working. That may affect their speed by quite a few seconds, especially for Problem 20.*
1. **Problem 10 Part 2**: 72m 35.891s
2. **Problem 20 Part 2**: 18m 22.611s
3. **Problem 20 Part 1**: 15m 26.441s (15m 9.086s when slightly optimized)

P10.2 in all its glory:

![image](Problem10/72m35.891s.png)

### Future Plans
If I were to come back to this repo and edit some of the solutions, I would definitely:
- **Optimize 10 (especially Part 2) and 20 (both parts).** They seriously took forever to finish running. Just look at their times in [Longest Runtimes](#Longest-Runtimes-Hall-Of-Shame-Fame).
