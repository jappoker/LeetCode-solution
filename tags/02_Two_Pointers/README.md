# Two Pointers
This folder contains problems and solutions related to two pointers.

# LC27_RemoveElement.java
* [Problem Link](https://leetcode.com/problems/remove-element/)
* [Solution Link](../../LC0001_1000/LC0001_0100/LC0027_RemoveElement.java)
* Idea: two pointers (`i` and `j`) starting from the beginning of `nums`. `i` is the slow pointer, `j` is the fast pointer. If `nums[j] != val`, put `nums[j]` to `nums[i]`, and increment `i`. Otherwise, increment `j`.

# LC88_MergeSortedArray.java
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
