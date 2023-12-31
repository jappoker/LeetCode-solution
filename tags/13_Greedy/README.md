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

# LC121_BestTimeToBuyAndSellStock.java
* [Problem Link](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
* [Solution Link](../../LC0001_1000/LC0101_0200/LC0121_BestTimeToBuyAndSellStock.java)
* Idea: Greedy. 
  * Variables:
    * `minPrice` is the minimum price that we have seen so far. 
    * `maxProfit` is the maximum profit that we can get so far. 
  * Conditions: If `prices[i] < minPrice`, it means that we can buy at `prices[i]` and sell at `minPrice` to get a larger profit. Otherwise, update `maxProfit` to `Math.max(maxProfit, prices[i] - minPrice)`.
```
[7,1,5,3,6,4]
i = 0, curPrice = 7, minPrice = 7, curProfit = 0, maxProfit = 0
i = 1, curPrice = 1, minPrice = 1, curProfit = 0, maxProfit = 0
i = 2, curPrice = 5, minPrice = 1, curProfit = 4, maxProfit = 4
i = 3, curPrice = 3, minPrice = 1, curProfit = 2, maxProfit = 4
i = 4, curPrice = 6, minPrice = 1, curProfit = 5, maxProfit = 5
i = 5, curPrice = 4, minPrice = 1, curProfit = 3, maxProfit = 5
```

