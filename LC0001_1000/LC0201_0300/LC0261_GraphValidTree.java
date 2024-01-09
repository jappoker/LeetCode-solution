package LC0001_1000.LC0201_0300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 261. Graph Valid Tree [medium]
 * https://leetcode.com/problems/graph-valid-tree/
 * 
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi]
 * indicates that there is an undirected edge between nodes ai and bi in the graph.
 * 
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 * 
 * Example 1:
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 * 
 * Example 2:
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * Output: false
 * 
 * Constraints:
 * 
 * 1 <= 2000 <= n
 * 0 <= edges.length <= 5000
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * There are no self-loops or repeated edges.
 * 
 */

public class LC0261_GraphValidTree {

    /**
     * Solution: DFS
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * @param n
     * @param edges
     * @return boolean
     */

    public boolean validTree1(int n, int[][] edges) {
        List<List<Integer>> adList = new ArrayList<>();

        for(int i = 0; i < n; i++) adList.add(new ArrayList<Integer>());

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adList.get(u).add(v);
            adList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        if(hasCycle(adList, 0, visited, -1)) return false;
        for (boolean v: visited) if (v == false) return false;
        return true;
    }

    private boolean hasCycle(List<List<Integer>> adList, int u, boolean[] visited, int prev){
        visited[u] = true;
        for(int i = 0; i < adList.get(u).size(); i++){
            int v = adList.get(u).get(i);
            if((visited[v] && prev != v) || (!visited[v] && hasCycle(adList, v, visited, u))) return true;
        }
        return false;
    }

    /**
     * Solution: Union Find
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * @param n
     * @param edges
     * @return boolean
     */

    public boolean validTree2(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int pu = find(parent, u);
            int pv = find(parent, v);
            if (pu == pv) return false;
            parent[pu] = pv;
        }
        return edges.length == n - 1;
    }

    private int find(int[] parent, int u){
        if(parent[u] == u) return u;
        return parent[u] = find(parent, parent[u]);
    }

    /**
     * Solution: BFS
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * @param n
     * @param edges
     * @return boolean
     */

    public boolean validTree3(int n, int[][] edges) {
        List<List<Integer>> adList = new ArrayList<>();

        for(int i = 0; i < n; i++) adList.add(new ArrayList<Integer>());

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adList.get(u).add(v);
            adList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int u = queue.poll();
            if(visited[u]) return false;
            visited[u] = true;
            for(int i = 0; i < adList.get(u).size(); i++){
                int v = adList.get(u).get(i);
                if(!visited[v]) queue.offer(v);
            }
        }
        for (boolean v: visited) if (v == false) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println("261. Graph Valid Tree [medium]");
        LC0261_GraphValidTree obj = new LC0261_GraphValidTree();
        int n = 5;
        int[][] edges = new int[][]{{0,1},{0,2},{0,3},{1,4}};
        System.out.println(obj.validTree1(n, edges)); // true
        System.out.println(obj.validTree2(n, edges)); // true
        System.out.println(obj.validTree3(n, edges)); // true
    }
    
}
