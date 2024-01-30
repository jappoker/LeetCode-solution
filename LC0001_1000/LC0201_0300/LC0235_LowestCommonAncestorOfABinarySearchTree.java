package LC0001_1000.LC0201_0300;


/**
 * 0235. Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia:
 * - “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 * 
 * Example 1:
 * - Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * - Output: 6
 * 
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * 
 * Example 2:
 * - Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * - Output: 2
 * 
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */

public class LC0235_LowestCommonAncestorOfABinarySearchTree {

    /**
     * Solution: Recursion
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        if(root.val < Math.min(p.val, q.val)){
            return lowestCommonAncestor(root.right, p, q);
        } else if(root.val > Math.max(p.val, q.val)){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println("LC 235 Lowest Common Ancestor of a Binary Search Tree [Medium]");
        
        // write a test case here
        LC0235_LowestCommonAncestorOfABinarySearchTree obj = new LC0235_LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = obj.new TreeNode(6);
        root.left = obj.new TreeNode(2);
        root.right = obj.new TreeNode(8);
        root.left.left = obj.new TreeNode(0);
        root.left.right = obj.new TreeNode(4);
        root.right.left = obj.new TreeNode(7);
        root.right.right = obj.new TreeNode(9);
        root.left.right.left = obj.new TreeNode(3);
        root.left.right.right = obj.new TreeNode(5);
        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println(obj.lowestCommonAncestor(root, p, q).val); // 6
    }
}
