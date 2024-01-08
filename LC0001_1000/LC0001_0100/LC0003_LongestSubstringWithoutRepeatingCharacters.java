package LC0001_1000.LC0001_0100;

/**
 * 3. Longest Substring Without Repeating Characters [medium]
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Example 4:
 * Input: s = "" Output: 0
 * 
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

public class LC0003_LongestSubstringWithoutRepeatingCharacters {

    /**
     * Solution: Sliding Window
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param s
     * @return int
     */

    public int lengthOfLongestSubstring(String s) {
        // corner case
        if(s == null || s.length() == 0) return 0;

        int[] count = new int[256];
        int i = 0;
        int result = 0;
        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            count[c]++;
            while(count[c] > 1){
                count[s.charAt(i++)]--;
            }
            result = Math.max(j - i + 1, result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("3. Longest Substring Without Repeating Characters [medium]");
        LC0003_LongestSubstringWithoutRepeatingCharacters solution = new LC0003_LongestSubstringWithoutRepeatingCharacters();
        String[] inputs = {"abcabcbb", "bbbbb", "pwwkew", ""};
        for(int i = 0; i < inputs.length; i++){
            System.out.println("Example " + (i + 1) + ":");
            System.out.println("Input: s = \"" + inputs[i] + "\"");
            System.out.println("Output: " + solution.lengthOfLongestSubstring(inputs[i]));
            System.out.println();
        }
    }
}
