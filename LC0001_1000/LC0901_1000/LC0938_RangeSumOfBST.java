package LC0001_1000.LC0901_1000;

/**
 * 938. Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/
 * 
 * Given the root node of a binary search tree, return the sum of values of all
 * nodes with a value in the range [low, high].
 * 
 * Example 1:
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15 Output: 32 Example 2:
 * 
 * Example 2:
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10 Output: 23
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 2 * 104]. 1 <= Node.val
 * <= 105 1 <= low <= high <= 105 All Node.val are unique.
 * 
 */

public class LC0938_RangeSumOfBST {

    /**
     * Solution: Recursion
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     * Space Complexity: O(H), where H is the height of the tree.
     * @param root
     * @param low
     * @param high
     * @return the sum of values of all nodes with a value in the range [low, high].
     */

    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int sum = 0;
        if (root.val >= low && root.val <= high) sum += root.val;
        if (root.val >= low) sum += rangeSumBST1(root.left, low, high);
        if (root.val <= high) sum += rangeSumBST1(root.right, low, high);
        return sum;
    }

    // Better
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if(root == null) return 0;
        if(root.val > high) return rangeSumBST2(root.left, low, high);
        if(root.val < low ) return rangeSumBST2(root.right, low, high);
        return root.val + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right,low, high);
    }

    // Not good, because it will traverse all the nodes, even if the node is not in the range.
    public int rangeSumBST3(TreeNode root, int low, int high) {
        if(root == null) return 0;
        int res = root.val >= low && root.val <= high ?root.val:0;
        return res + rangeSumBST3(root.left, low, high) +  rangeSumBST3(root.right, low, high) ;
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
        
        System.out.println("938. Range Sum of BST [easy]");
        LC0938_RangeSumOfBST solution = new LC0938_RangeSumOfBST();
        TreeNode root = solution.new TreeNode(10);
        root.left = solution.new TreeNode(5);
        root.right = solution.new TreeNode(15);
        root.left.left = solution.new TreeNode(3);
        root.left.right = solution.new TreeNode(7);
        root.right.right = solution.new TreeNode(18);
        System.out.println(solution.rangeSumBST1(root, 7, 15)); // 32
    }

}