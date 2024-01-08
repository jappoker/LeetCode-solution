# Tree
This folder contains problems and solutions related to tree.

## Binary Search Tree
### LC938_RangeSumOfBST
* [LC938_RangeSumOfBST](https://leetcode.com/problems/range-sum-of-bst/description/)
* [Solution](../LC0001_1000/LC0901_1000/LC0938_RangeSumOfBST.java)
* Idea: Binary Search Tree. 
  * Variables:
    * `sum` is the sum of nodes' values in the range `[L, R]`.
  * Conditions: 
    * If `root == null`, return `0`.
    * If `root.val < L`, return `rangeSumBST(root.right, L, R)`.
    * If `root.val > R`, return `rangeSumBST(root.left, L, R)`.
    * Otherwise, return `root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R)`.

