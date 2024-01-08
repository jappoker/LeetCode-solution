# Two Pointers
This folder contains problems and solutions related to two pointers.

## LC3_LongestSubstringWithoutRepeatingCharacters.java
* [Problem Link](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
* [Solution Link](../../LC0001_1000/LC0001_0100/LC0003_LongestSubstringWithoutRepeatingCharacters.java)

## LC15_3Sum.java
* [Problem Link](https://leetcode.com/problems/3sum/)
* [Solution Link](../../LC0001_1000/LC0011_0020/LC0015_3Sum.java)
* Idea: two pointers (`i` and `j`) starting from the beginning and end of `nums`, respectively. If `nums[i] + nums[j] + nums[k] == target`, return `{i, j, k}`. Sort the array first, then for each `nums[i]`, use two pointers starting from `i + 1` and `n - 1` to find the solution.

## LC26_RemoveDuplicatesFromSortedArray.java
* [Problem Link](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
* [Solution Link](../../LC0001_1000/LC0001_0100/LC0026_RemoveDuplicatesFromSortedArray.java)
* Idea: two pointers (`i` and `j`) starting from the beginning of `nums`. `i` is the slow pointer, `j` is the fast pointer. If `nums[i-1] == nums[j]`, increment `j` (skip this element). Otherwise, put `nums[j]` to `nums[i]`, and increment `i`.

## LC27_RemoveElement.java
* [Problem Link](https://leetcode.com/problems/remove-element/)
* [Solution Link](../../LC0001_1000/LC0001_0100/LC0027_RemoveElement.java)
* Idea: two pointers (`i` and `j`) starting from the beginning of `nums`. `i` is the slow pointer, `j` is the fast pointer. If `nums[j] != val`, put `nums[j]` to `nums[i]`, and increment `i`. Otherwise, increment `j`.

## LC80_RemoveDuplicatesFromSortedArrayII.java
* [Problem Link](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)
* [Solution Link](../../LC0001_1000/LC0071_0080/LC0080_RemoveDuplicatesFromSortedArrayII.java)
* Idea: two pointers (`i` and `j`) starting from the beginning of `nums`. `i` is the slow pointer, `j` is the fast pointer. If `nums[i-2] == nums[j]`, increment `j` (skip this element). Otherwise, put `nums[j]` to `nums[i]`, and increment `i`. 

## LC88_MergeSortedArray.java
* [Problem Link](https://leetcode.com/problems/merge-sorted-array/)
* [Solution Link](../../LC0001_1000/LC0001_0100/LC0088_MergeSortedArray.java)
* Idea: two pointers (`i` and `j`) starting from the end of `nums1` and `nums2`, respectively. Compare `nums1[i]` and `nums2[j]`, put the larger number to `nums1[cur]`
* Key point: Start from the end. If start from the beginning, there will be overwriting problem.
```
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6], n = 3
     i    cur
[1,2,3,0,0,0]
[2,5,6]
     j

     i  cur
[1,2,3,0,0,6]
[2,5,6]
   j

     i cur
[1,2,3,0,5,6]
[2,5,6]
 j
   i cur
[1,2,3,3,5,6]
[2,5,6]
 j

   i,cur
[1,2,2,3,5,6]
[2,5,6]
j
```
## LC125_ValidPalindrome.java
* [Problem Link](https://leetcode.com/problems/valid-palindrome/)
* [Solution Link](../../LC0001_1000/LC0121_0130/LC0125_ValidPalindrome.java)
* Idea: two pointers (`i` and `j`) starting from the beginning and end of `s`, respectively. If `s[i]` is not alphanumeric, increment `i`. If `s[j]` is not alphanumeric, decrement `j`. If `s[i]` and `s[j]` are both alphanumeric, compare them. If they are not equal, return `false`. Otherwise, increment `i` and decrement `j`.

## LC167_TwoSumII_InputArrayIsSorted.java
* [Problem Link](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
* [Solution Link](../../LC0001_1000/LC0161_0170/LC0167_TwoSumII_InputArrayIsSorted.java)
* Idea: two pointers (`i` and `j`) starting from the beginning and end of `nums`, respectively. If `nums[i] + nums[j] == target`, return `[i+1, j+1]`. If `nums[i] + nums[j] < target`, increment `i`. If `nums[i] + nums[j] > target`, decrement `j`.

## LC209_MinimumSizeSubarraySum.java
* [Problem Link](https://leetcode.com/problems/minimum-size-subarray-sum/)
* [Solution Link](../../LC0001_1000/LC0201_0300/LC0209_MinimumSizeSubarraySum.java)
* Idea: two pointers (`i` and `j`) starting from the beginning of `nums`. `i` is the slow pointer, `j` is the fast pointer. If `sum < s`, increment `j`. If `sum >= s`, update the answer, and increment `i`.