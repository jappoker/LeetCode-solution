# Greedy
This folder contains problems and solutions related to greedy algorithms.

# LC45_JumpGameII.java
This can be a followup question for [LC55_JumpGame.java](#lc55_jumpgamejava)!
* [Problem Link](https://leetcode.com/problems/jump-game-ii/)
* [Solution Link](../../LC0001_1000/LC0001_0100/LC0045_JumpGameII.java)
* Idea: Greedy. 
  * Variables:
    * `maxPos` is the farthest position that can be reached. 
    * `end` is the end of the current jump. 
    * `steps` is the number of jumps. 
  * Conditions: If `i == end`, it means that we have reached the end of the current jump. We need to jump again. `end = maxPos` and `steps++`.
```
Example: nums = [2, 3, 1, 1, 4]
i = 0: maxPos = 2, end = 0, steps = 0;
i = 1: maxPos = 4, end = 2, steps = 1; 
i = 2: maxPos = 4, end = 2, steps = 1;
i = 3: maxPos = 4, end = 4, steps = 2; finished
```


# LC55_JumpGame.java
* [Problem Link](https://leetcode.com/problems/jump-game/)
* [Solution Link](../../LC0001_1000/LC0001_0100/LC0055_JumpGame.java)
* Idea: Greedy. 
  * Variables:
    * `maxPos` is the farthest position that can be reached. 
  * Conditions: If `i > maxPos`, it means that we cannot reach `i`. Return `false`. Otherwise, update `maxPos` to `Math.max(maxPos, i + nums[i])`.
```
maxJump = Math.max(maxJump, i + nums[i])

[2,3,1,1,4]
2 (3 1) 1 4  maxJump = 2
2 3 (1 1 4)  maxJump = 4 (since 1+3 > 2)
2 3 1 (1 4)  maxJump = 4 (no change, since 2+1 <= 4)
2 3 1 1 (4)  maxJump = 4 (no change, since 3+1 <= 4)
```

