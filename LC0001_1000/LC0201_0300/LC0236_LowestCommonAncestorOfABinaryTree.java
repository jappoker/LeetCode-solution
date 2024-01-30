package LC0001_1000.LC0201_0300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.TreeNode;

/**
 * 0236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia:
 * - “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 *  (where we allow a node to be a descendant of itself).”
 * 
 * Example 1:
 * - Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * - Output: 3
 * 
 * Example 2:
 * - Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * - Output: 5
 */

public class LC0236_LowestCommonAncestorOfABinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Solution 1: Recursion
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(p == null || q == null) return null;
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if(root == p) return p;
        if(root == q) return q;
        if(left != null && right != null) return root;
        if(left != null) return left;
        return right;
    }

    /**
     * Solution 2: Recursion, use count to record the number of p and q in the subtree
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */

    TreeNode res;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(p == null || q == null) return null;
        res = null;
        helper(root, p, q);
        return res;
    }

    public int helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || res != null) return 0;
        int left = helper(root.left, p, q);
        int right = helper(root.right, p, q);
        int count = left + right;
        if(root == p || root == q) count++;
        if(count == 2 && res == null) res = root;
        return count;
    }

    /**
     * Solution 3: Iteration
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(p == null || q == null) return null;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, null);
        while(!map.containsKey(p) || !map.containsKey(q)){
            TreeNode node = queue.poll();
            if(node.left != null){
                map.put(node.left, node);
                queue.offer(node.left);
            }
            if(node.right != null){
                map.put(node.right, node);
                queue.offer(node.right);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while(p != null){
            set.add(p);
            p = map.get(p);
        }
        while(!set.contains(q)){
            q = map.get(q);
        }
        return q;
    }

    public static void main(String[] args) {
        System.out.println("236. Lowest Common Ancestor of a Binary Tree [medium]");
        LC0236_LowestCommonAncestorOfABinaryTree ll = new LC0236_LowestCommonAncestorOfABinaryTree();
        TreeNode root = ll.new TreeNode(3);
        root.left = ll.new TreeNode(5);
        root.right = ll.new TreeNode(1);
        root.left.left = ll.new TreeNode(6);
        root.left.right = ll.new TreeNode(2);
        root.right.left = ll.new TreeNode(0);
        root.right.right = ll.new TreeNode(8);
        root.left.right.left = ll.new TreeNode(7);
        root.left.right.right = ll.new TreeNode(4);
        System.out.println(ll.lowestCommonAncestor1(root, root.left, root.right).val); // 3
        System.out.println(ll.lowestCommonAncestor2(root, root.left, root.right).val); // 3
        System.out.println(ll.lowestCommonAncestor3(root, root.left, root.right).val); // 3

    }
}
