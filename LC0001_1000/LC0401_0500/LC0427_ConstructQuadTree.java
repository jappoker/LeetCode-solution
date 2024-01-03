package LC0001_1000.LC0401_0500;

/**
 * 427. Construct Quad Tree
 * https://leetcode.com/problems/construct-quad-tree/
 * 
 * Given a n * n matrix grid of 0's and 1's only. We want to represent the grid
 * with a Quad-Tree.
 * 
 * Return the root of the Quad-Tree representing the grid.
 * 
 * Notice that you can assign the value of a node to True or False when isLeaf
 * is False, and both are accepted in the answer.
 * 
 * A Quad-Tree is a tree data structure in which each internal node has exactly
 * four children. Besides, each node has two attributes:
 * 
 * val: True if the node represents a grid of 1's or False if the node
 * represents a grid of 0's. isLeaf: True if the node is leaf node on the tree
 * or False if the node has the four children. class Node { public boolean val;
 * public boolean isLeaf; public Node topLeft; public Node topRight; public
 * Node bottomLeft; public Node bottomRight; }
 * 
 * Examples see the picture on the leetcode website.
 * 
 */

public class LC0427_ConstructQuadTree {
    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    /**
     * Solution: Recursion (Divide and Conquer)
     * Time Complexity: O(N^2) -> 4 ^ log4(N) = N^2; or bottom up: each ij is visited once, so O(N^2)
     * Space Complexity: O(1)
     * 
     * @param grid
     * @return the root of the Quad-Tree representing the grid
     */

    public Node construct(int[][] grid) {
        // corner case;
        if(grid == null || grid.length == 0 || grid[0].length == 0) return null;

        int n = grid.length;
        Node root = quadTree(grid,0, 0, n);
        return root;
    }

    private Node quadTree(int[][] grid, int i, int j, int width){
        if(width == 1){
            return new Node(grid[i][j]==1, true); // base case
        }
        int nextWidth = width / 2;
        Node topLeft = quadTree(grid, i, j, nextWidth);
        Node topRight = quadTree(grid, i, j + nextWidth, nextWidth);
        Node bottomLeft = quadTree(grid, i + nextWidth, j, nextWidth);
        Node bottomRight = quadTree(grid, i + nextWidth, j + nextWidth, nextWidth);

        boolean isLeaf = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && ((topRight.val && topLeft.val && bottomLeft.val && bottomRight.val) || (!topRight.val && !topLeft.val && !bottomLeft.val && !bottomRight.val));
        if(isLeaf){
            return new Node(grid[i][j]==1, true);
        }
        return new Node(grid[i][j]==1, false, topLeft, topRight, bottomLeft, bottomRight );
    }

    public static void main(String[] args) {
        System.out.println("427. Construct Quad Tree [medium]");
        LC0427_ConstructQuadTree s = new LC0427_ConstructQuadTree();
        int[][] grid = new int[][]{{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,1,1},{1,1,1,1,0,0,1,1}};
        Node root = s.construct(grid);
        System.out.println(root); 
    }
    
}
