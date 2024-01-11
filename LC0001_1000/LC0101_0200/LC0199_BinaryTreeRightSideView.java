package LC0001_1000.LC0101_0200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 199. Binary Tree Right Side View [medium]
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * 
 * Example 2:
 * Input: root = [1,null,3]
 * Output: [1,3]
 * 
 * Example 3:
 * Input: root = []
 * Output: []
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 */
public class LC0199_BinaryTreeRightSideView {

    /**
     * Solution: DFS
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * @param root
     * @return List<Integer>
     */
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth){
        if(node == null) return;
        if(res.size() == depth) res.add(node.val);
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("199. Binary Tree Right Side View [medium]");
        LC0199_BinaryTreeRightSideView s = new LC0199_BinaryTreeRightSideView();
        TreeNode root = s.new TreeNode(1);
        root.left = s.new TreeNode(2);
        root.right = s.new TreeNode(3);
        root.left.right = s.new TreeNode(5);
        root.right.right = s.new TreeNode(4);
        System.out.println(s.rightSideView(root).toString()); // [1, 3, 4]

    }
}
