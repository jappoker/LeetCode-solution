package LC0001_1000.LC0301_0400;

/**
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence/
 * 
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise.
 * 
 * A subsequence of a string is a new string that is formed from the original
 * string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining
 * characters. (i.e., "ace" is a subsequence
 * of "abcde" while "aec" is not).
 * 
 * Example 1:
 * 
 * Input: s = "abc", t = "ahbgdc" 
 * Output: true 
 * 
 * Example 2:
 * 
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 */
public class LC0392_IsSubsequence {

    /**
     * Solution: Two Pointers with API call indexOf
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param s
     * @param t
     * @return true if s is a subsequence of t, or false otherwise
     */
    public boolean isSubsequence1(String s, String t) {
        int curIndex = 0;

        for(char c: s.toCharArray()){
            int index = t.indexOf(c, curIndex);
            if(index < 0) return false;
            curIndex = index +1;
        }

        return true;
    }

    /**
     * Solution: Two Pointers
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param s
     * @param t
     * @return true if s is a subsequence of t, or false otherwise
     */

    public boolean isSubsequence2(String s, String t) {
        int j = 0;
        for(int i = 0; i < t.length() && j < s.length(); i++){
            if(t.charAt(i) == s.charAt(j)) j++;
        }
        if(j == s.length()) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println("392. Is Subsequence [easy]");
        LC0392_IsSubsequence solution = new LC0392_IsSubsequence();
        System.out.println("Example 1: Input: s = \"abc\", t = \"ahbgdc\"\nOutput: " + solution.isSubsequence1("abc", "ahbgdc"));
        System.out.println("Example 2: Input: s = \"axc\", t = \"ahbgdc\"\nOutput: " + solution.isSubsequence1("axc", "ahbgdc"));
        System.out.println("Example 1: Input: s = \"abc\", t = \"ahbgdc\"\nOutput: " + solution.isSubsequence2("abc", "ahbgdc"));
        System.out.println("Example 2: Input: s = \"axc\", t = \"ahbgdc\"\nOutput: " + solution.isSubsequence2("axc", "ahbgdc"));
    }
}
