# Tree
This folder contains problems and solutions related to tree.

## Construct Binary Tree
### LC105_ConstructBinaryTreeFromPreorderAndInorderTraversal
* [LC105_ConstructBinaryTreeFromPreorderAndInorderTraversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/)
* [Solution](../../LC0001_1000/LC0101_0200/LC0105_ConstructBinaryTreeFromPreorderAndInorderTraversal.java)
* Idea: 
  * Build a hashmap to record the relation of value -> index for inorder.
  * Use an integer variable `preorderIndex` to keep track of the element that will be used to construct the root.
  * Implement the recursion function returns the constructed binary tree:     
    * if the range is empty, return null;
    * initialize the root with val of `preorder[preorderIndex]++`;
    * recursively use the left and right portions of inorder to construct the left and right subtrees.
      * `root.left = helper(preorder, left, map.get(val) - 1);` 
      * `root.right = helper(preorder, map.get(val) + 1, right);`

### LC106_ConstructBinaryTreeFromInorderAndPostorderTraversal
* [LC106_ConstructBinaryTreeFromInorderAndPostorderTraversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/)
* [Solution](../../LC0001_1000/LC0101_0200/LC0106_ConstructBinaryTreeFromInorderAndPostorderTraversal.java)
* Idea: 
  * Build a hashmap to record the relation of value -> index for inorder.
  * Use an integer variable `postorderIndex` to keep track of the element that will be used to construct the root.
  * Implement the recursion function returns the constructed binary tree:     
    * if the range is empty, return null;
    * initialize the root with val of `postorder[postorderIndex]--`;
    * recursively use the left and right portions of inorder to construct the left and right subtrees.
      * `root.right = helper(inorder, map.get(val) + 1, right);` 
      * `root.left = helper(inorder, left, map.get(val) - 1);`



## Binary Search Tree
### LC938_RangeSumOfBST
* [LC938_RangeSumOfBST](https://leetcode.com/problems/range-sum-of-bst/description/)
* [Solution](../../LC0001_1000/LC0901_1000/LC0938_RangeSumOfBST.java)
* Idea: Binary Search Tree. 
  * Variables:
    * `sum` is the sum of nodes' values in the range `[L, R]`.
  * Conditions: 
    * If `root == null`, return `0`.
    * If `root.val < L`, return `rangeSumBST(root.right, L, R)`.
    * If `root.val > R`, return `rangeSumBST(root.left, L, R)`.
    * Otherwise, return `root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R)`.

