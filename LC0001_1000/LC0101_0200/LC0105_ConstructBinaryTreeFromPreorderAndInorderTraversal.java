package LC0001_1000.LC0101_0200;

import java.util.HashMap;

import javax.swing.tree.TreeNode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * Given two integer arrays preorder and inorder where preorder is the preorder
 * traversal of a binary tree and inorder is the inorder traversal of the same
 * tree, construct and return the binary tree.
 * 
 * Example 1:
 * 
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7] 
 * Output: [3,9,20,null,null,15,7] 
 * 
 * Example 2:
 * 
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * 
 * Constraints:
 * 
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 */

public class LC0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * Solution
     * 
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     * Space Complexity: O(H), where H is the height of the tree.
     * 
     * @param preorder
     * @param inorder
     * @return the root of the binary tree
     */

    HashMap<Integer, Integer> map; // {key: val, val: index of inorder}
    int preorderIndex;         // global variable
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        preorderIndex = 0;
        int n = inorder.length;
        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, n - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right){
        if(left > right) return null;

        int val = preorder[preorderIndex++]; // preorderIndex is global variable
        TreeNode root = new TreeNode(val);   // and is always the current root

        root.left = helper(preorder, left, map.get(val) - 1); 
        root.right = helper(preorder, map.get(val) + 1, right);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        
        System.out.println("105. Construct Binary Tree from Preorder and Inorder Traversal [medium]");
        LC0105_ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new LC0105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = new int[]{3,9,20,15,7}, inorder = new int[]{9,3,15,20,7};
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println(root.val);

    }
}
