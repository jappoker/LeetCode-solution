package LC0001_1000.LC0101_0200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal [medium]
 * 
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 * 
 * Example 1:
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * 
 * Example 2:
 * 
 * Input: root = [1]
 * Output: [[1]]
 * 
 * Example 3:
 * 
 * Input: root = []
 * Output: []
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */

public class LC0102_BinaryTreeLevelOrderTraversal {

    /**
     * Solution: BFS
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * @param root
     * @return List<List<Integer>>
     */

    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            result.add(new ArrayList<>());
            int size = q.size();
            int level = result.size() - 1;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                result.get(level).add(node.val);
                if(node.left!= null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
        }
        return result;
    }

    /**
     * Solution: DFS
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * @param root
     * @return List<List<Integer>>
     */

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0, result);
        return result;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> result){
        if(root == null) return;
        if(result.size() == level) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
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
        System.out.println("102. Binary Tree Level Order Traversal [medium]");
        LC0102_BinaryTreeLevelOrderTraversal ss = new LC0102_BinaryTreeLevelOrderTraversal();
        TreeNode root = ss.new TreeNode(3);
        root.left = ss.new TreeNode(9);
        root.right = ss.new TreeNode(20);
        root.right.left = ss.new TreeNode(15);
        root.right.right = ss.new TreeNode(7);
        System.out.println(ss.levelOrderBFS(root)); // [[3],[9,20],[15,7]]
        System.out.println(ss.levelOrderDFS(root)); // [[3],[9,20],[15,7]]
    }
    
}
