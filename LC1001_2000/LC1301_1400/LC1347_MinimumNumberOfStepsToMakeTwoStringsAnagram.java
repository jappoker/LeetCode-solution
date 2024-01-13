package LC1001_2000.LC1301_1400;

/**
 * 1347. Minimum Number of Steps to Make Two Strings Anagram
 * 
 * Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
 * 
 * Return the minimum number of steps to make t an anagram of s.
 * 
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 * 
 * Example 1:
 * Input: s = "bab", t = "aba"
 * Output: 1
 * 
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 * 
 * Example 2:
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * 
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 * 
 * Example 3:
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * 
 * Explanation: "anagram" and "mangaar" are anagrams.
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 50000
 * s.length == t.length
 * s and t contain lower-case English letters only.
 */
public class LC1347_MinimumNumberOfStepsToMakeTwoStringsAnagram {

    /**
     * Solution: Counting
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param s: a string
     * @param t: a string
     * @return: return the minimum number of steps to make t an anagram of s
     */
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        int n = t.length();
        for(int i = 0; i < n; i++){
            count[t.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
        }
        int result = 0;
        for(int i = 0; i < 26; i++){
            result += Math.abs(count[i]);
        }
        return result / 2;
    }
    
    public static void main(String[] args) {
        System.out.println("1347. Minimum Number of Steps to Make Two Strings Anagram\n");
        LC1347_MinimumNumberOfStepsToMakeTwoStringsAnagram lc1347 = new LC1347_MinimumNumberOfStepsToMakeTwoStringsAnagram();
        System.out.println(lc1347.minSteps("bab", "aba")); // 1
        System.out.println(lc1347.minSteps("leetcode", "practice")); // 5
        System.out.println(lc1347.minSteps("anagram", "mangaar")); // 0
    }
}
