package LC0001_1000.LC0101_0200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands [medium]
 * 
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 
 * Output: 3
 */
public class LC0200_NumberOfIslands{

    /**
     * Solution: DFS / BFS
     * Time Complexity: O(M*N)
     * Space Complexity: O(M*N)
     * 
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        // corner case
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return -1;

        int count = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == '1'){
                    count ++;
                    // dfs(grid, i, j);
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * Solution: DFS
     * Time Complexity: O(M*N)
     * Space Complexity: O(M*N)
     * 
     * @param grid
     * @param i
     * @param j
     */
    private void dfs(char[][] grid, int i, int j){
        // corner case
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;

        if(grid[i][j] == '0') return;

        grid[i][j] = '0';
        dfs(grid, i -1, j); 
        dfs(grid, i +1, j); 
        dfs(grid, i, j - 1); 
        dfs(grid, i, j + 1); 
        
    }

    /**
     * Solution: BFS
     * Time Complexity: O(M*N)
     * Space Complexity: O(M*N)
     * 
     * @param grid
     * @param i
     * @param j
     */
    
    private void bfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int x = 0; x < size; x ++){
                int[] curPosition = queue.poll();
                i = curPosition[0];
                j = curPosition[1];
                int[][] nextPositions = {{i-1, j}, {i + 1, j}, {i, j-1}, {i, j +1}};
                for(int[] nextPosition: nextPositions){
                    if(0 <= nextPosition[0] && nextPosition[0] < grid.length && 0 <= nextPosition[1]&& nextPosition[1] < grid[0].length && grid[nextPosition[0]][nextPosition[1]] == '1'){
                        queue.offer(nextPosition);
                        grid[nextPosition[0]][nextPosition[1]] = '0';
                    }
                }   
            }
        }
    }

    /**
     * Solution: Union Find
     * Time Complexity: O(M*N)
     * Space Complexity: O(M*N)
     * 
     * @param grid
     * @return
     */

    int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands2(char[][] grid) {  
        if (grid == null || grid.length == 0 || grid[0].length == 0)  {
            return 0;  
        }
        UnionFind uf = new UnionFind(grid);  
        int rows = grid.length;  
        int cols = grid[0].length;  
        for (int i = 0; i < rows; i++) {  
            for (int j = 0; j < cols; j++) {  
                if (grid[i][j] == '1') {  
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {  
                            int id1 = i*cols+j;
                            int id2 = x*cols+y;
                            uf.union(id1, id2);  
                        }  
                    }  
                }  
            }  
        }  
        return uf.count;  
    }
    class UnionFind {
        int[] father;  
        int m, n;
        int count = 0;
        UnionFind(char[][] grid) {  
            m = grid.length;  
            n = grid[0].length;  
            father = new int[m*n];  
            for (int i = 0; i < m; i++) {  
                for (int j = 0; j < n; j++) {  
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        father[id] = id;
                        count++;
                    }
                }  
            }  
        }
        public void union(int node1, int node2) {  
            int find1 = find(node1);
            int find2 = find(node2);
            if(find1 != find2) {
                father[find1] = find2;
                count--;
            }
        }
        public int find (int node) {  
            if (father[node] == node) {  
                return node;
            }
            father[node] = find(father[node]);  
            return father[node];
        }
    }
    public static void main(String[] args) {
        LC0200_NumberOfIslands solution = new LC0200_NumberOfIslands();
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','1'}};
        System.out.println(solution.numIslands(grid)); // 1

        grid = new char[][]{{'1','1','1','1','0'},
                            {'1','1','0','1','0'},
                            {'1','1','0','0','0'},
                            {'0','0','0','0','1'}};
        System.out.println(solution.numIslands2(grid)); // 1
    }
}
