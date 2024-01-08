package LC0001_1000.LC0101_0200;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * Given two integer arrays inorder and postorder where inorder is the inorder
 * traversal of a binary tree and postorder is the postorder traversal of the
 * same tree, construct and return the binary tree.
 * 
 * Example 1:
 * 
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * 
 * Example 2:
 * 
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 * 
 * Constraints:
 * 
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 */

public class LC0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     * Solution: Recursion
     * 
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     * Space Complexity: O(H), where H is the height of the tree.
     * 
     * @param inorder
     * @param postorder
     * @return the root of the binary tree
     */
    Map<Integer,Integer> map; // {key: val, val: inorder index}
    int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0) return null;

        int n = inorder.length;
        map = new HashMap<>();
        postorderIndex = n - 1;
        
        for(int i = 0; i < n; i++) map.put(inorder[i], i);
        return helper(postorder, 0, n - 1);
    }

    private TreeNode helper(int[] postorder, int left, int right){
        if(left > right) return null;
        int val = postorder[postorderIndex--];
        TreeNode root = new TreeNode(val);
        root.right = helper(postorder, map.get(val) + 1, right);
        root.left = helper(postorder, left, map.get(val) - 1);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println("106. Construct Binary Tree from Inorder and Postorder Traversal [medium]");
        LC0106_ConstructBinaryTreeFromInorderAndPostorderTraversal solution = new LC0106_ConstructBinaryTreeFromInorderAndPostorderTraversal();
        int[] inorder = new int[]{9,3,15,20,7}, postorder = new int[]{9,15,7,20,3};
        TreeNode root = solution.buildTree(inorder, postorder);
        System.out.println(root.val);
    }
}
