package LC0001_1000.LC0001_0100;

/**
 * 98. Validate Binary Search Tree [medium]
 * 
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * A valid BST is defined as follows:
 * 1. The left subtree of a node contains only nodes with keys less than the node's key.
 * 2. The right subtree of a node contains only nodes with keys greater than the node's key.
 * 3. Both the left and right subtrees must also be binary search trees.
 * 
 * Example 1:
 * 
 * Input: root = [2,1,3]
 * Output: true
 * 
 * Example 2:
 * 
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104].
 * -2^31 <= Node.val <= 2^31 - 1
 */

public class LC0098_ValidateBinarySearchTree {

    /**
     * Solution: DFS
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * @param root
     * @return boolean
     */

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { 
            this.val = val; 
        }
        TreeNode(int val, TreeNode left, TreeNode right) { 
            this.val = val; 
            this.left = left; 
            this.right = right; 
        }
    }

    public static void main(String[] args) {
        System.out.println("98. Validate Binary Search Tree [medium]");
        LC0098_ValidateBinarySearchTree ss = new LC0098_ValidateBinarySearchTree();
        TreeNode root = ss.new TreeNode(2);
        root.left = ss.new TreeNode(1);
        root.right = ss.new TreeNode(3);
        System.out.println(ss.isValidBST(root)); // true
    }
    
}
