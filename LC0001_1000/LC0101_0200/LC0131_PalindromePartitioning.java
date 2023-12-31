package LC0001_1000.LC0101_0200;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * A palindrome string is a string that reads the same backward as forward.
 * 
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * 
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 * 
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */

public class LC0131_PalindromePartitioning {

    /**
     * Solution1: DFS + Backtracking + Memoization
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(N^2)
     * @param s String
     * @return List<List<String>>
     */
    class Solution1{
        List<List<String>> result;
        boolean[][] dp;
        public List<List<String>> partition(String s) {
            result = new ArrayList<>();
            int n = s.length();
            dp = new boolean[n][n];

            dfs(s, 0, new ArrayList<>());
            return result;
        }

        private void dfs(String s, int start, List<String> path){
            int n = s.length();
            if(start >= n) result.add(new ArrayList<>(path));

            for(int i = start; i < n; i++){
                if(s.charAt(i) != s.charAt(start)) continue;
                if(i - 1 > start + 1 && !dp[start + 1][i-1]) continue;
                dp[start][i] = true;
                path.add(s.substring(start, i + 1));
                dfs(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LC0131_PalindromePartitioning obj = new LC0131_PalindromePartitioning();
        System.out.println(obj.new Solution1().partition("aab")); // [["a","a","b"],["aa","b"]]
        System.out.println(obj.new Solution1().partition("a")); // [["a"]]
        System.out.println(obj.new Solution1().partition("abcba")); // [["a","b","c","b","a"],["a","bcb","a"],["abcba"]]
    }
}

/*
 * DFS + Backtracking + Memoization Solution
 * Demo
 * 
    start: 0 path: []
    dp: 
    0 0 0 
    0 0 0 
    0 0 0 
    start: 1 path: [a]
    dp: 
    1 0 0 
    0 0 0 
    0 0 0 
    start: 2 path: [a, a]
    dp: 
    1 0 0 
    0 1 0 
    0 0 0 
    start: 3 path: [a, a, b]
    dp: 
    1 0 0 
    0 1 0 
    0 0 1 
    start: 2 path: [aa]
    dp: 
    1 1 0 
    0 1 0 
    0 0 1 
    start: 3 path: [aa, b]
    dp: 
    1 1 0 
    0 1 0 
    0 0 1 
    [[a, a, b], [aa, b]]
 */