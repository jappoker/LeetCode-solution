# Introduction
This file contains a series of questions with their possible followup questions, named by [Question Series - [Solutions]] (where * means primary solution), sorted by alphabetical order.

# 2Sum/3Sum/4Sum [*Two Pointers + HashMap]
1. Basic Question: [LC1_TwoSum.java](../LC0001_1000/LC0001_0100/LC0001_TwoSum.java), `nums[i] + nums[j] = target`, return `{i, j}`.
2. Sorted Array: [LC167_TwoSumII_InputArrayIsSorted.java](../LC0001_1000/LC0161_0170/LC0167_TwoSumII_InputArrayIsSorted.java), `nums[i] + nums[j] = target`, return `{i + 1, j + 1}`. (Notice that the array is sorted & the index starts from 1)

# Best Time to Buy and Sell Stock [*Greedy]
1. Basic Question: [LC121_BestTimeToBuyAndSellStock.java](../LC0001_1000/LC0101_0200/LC0121_BestTimeToBuyAndSellStock.java), only one transaction is allowed.
2. Followup 1: [LC122_BestTimeToBuyAndSellStockII.java](../LC0001_1000/LC0101_0200/LC0122_BestTimeToBuyAndSellStockII.java), multiple transactions are allowed.

# Jump Game [*Greedy/DP]
1. Basic Question: [LC55_JumpGame.java](../LC0001_1000/LC0001_0100/LC0055_JumpGame.java), can jump to the end or not?
2. Followup: [LC45_JumpGameII.java](../LC0001_1000/LC0001_0100/LC0045_JumpGameII.java), minimum number of jumps to reach the end?

# Palindrome [*DP]
1. Basic Question: [Two Pointers] [LC125_ValidPalindrome.java](../LC0001_1000/LC0121_0130/LC0125_ValidPalindrome.java), check if a string is palindrome.
2. [*DFS+Backtracing]: [LC131_PalindromePartitioning.java](../LC0001_1000/LC0101_0200/LC0131_PalindromePartitioning.java), partition a string into palindrome substrings.

# Remove Duplicates from Sorted Array [*Two Pointers]
1. Basic Question: [LC26_RemoveDuplicatesFromSortedArray.java](../LC0001_1000/LC0001_0100/LC0026_RemoveDuplicatesFromSortedArray.java), remove duplicates from sorted array: `nums[fast]!=nums[slow-1]`
2. Keep at most 2 duplicates: [LC80_RemoveDuplicatesFromSortedArrayII.java](../LC0001_1000/LC0071_0080/LC0080_RemoveDuplicatesFromSortedArrayII.java): `nums[fast]!=nums[slow-2]`
3. Can extend to keep at most k duplicates: `nums[fast]!=nums[slow-k]`