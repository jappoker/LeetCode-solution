# Greedy
This folder contains problems and solutions related to greedy algorithms.

# LC55_JumpGame.java
* [Problem Link](https://leetcode.com/problems/jump-game/)
* [Solution Link](../../LC0001_1000/LC0001_0100/LC0055_JumpGame.java)
```
maxJump = Math.max(maxJump, i + nums[i])

[2,3,1,1,4]
2 (3 1) 1 4  maxJump = 2
2 3 (1 1 4)  maxJump = 4 (since 1+3 > 2)
2 3 1 (1 4)  maxJump = 4 (no change, since 2+1 <= 4)
2 3 1 1 (4)  maxJump = 4 (no change, since 3+1 <= 4)
```

