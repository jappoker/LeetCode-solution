package LC0001_1000.LC0301_0400;

/**
 * 316. Remove Duplicate Letters [medium]
 * https://leetcode.com/problems/remove-duplicate-letters/
 * 
 * Given a string s, remove duplicate letters so that every letter appears once
 * and only once.
 * You must make sure your result is the smallest in lexicographical order among
 * all possible results.
 * 
 * Example 1:
 * Input: s = "bcabc"
 * Output: "abc"
 * 
 * Example 2:
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 * 
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 */

public class LC0316_RemoveDuplicateLetters {

    /**
     * Solution: Monotonic Stack
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param s
     * @return String
     */
    public String removeDuplicateLetters1(String s) {
        int[] count = new int[26];
        boolean[] seen = new boolean[26];
        StringBuilder res = new StringBuilder(); // use StringBuilder to simulate stack
        char[] ss = s.toCharArray();
        for (char c : ss)
            count[c - 'a']++;
        for (char c : ss) {
            count[c - 'a']--;
            if (seen[c - 'a'])
                continue;
            while (res.length() > 0 && res.charAt(res.length() - 1) > c // if stack is not empty and the top element is
                                                                        // larger than current element
                    && count[res.charAt(res.length() - 1) - 'a'] != 0) {// if the top element is not the last one in
                                                                        // the string
                                                                        // pop the top element by:
                seen[res.charAt(res.length() - 1) - 'a'] = false; // mark the top element as unseen
                res.deleteCharAt(res.length() - 1); // delete the top element
            }
            // push the current element by:
            seen[c - 'a'] = true; // mark the current element as seen
            res.append(c); // append the current element
        }
        return res.toString();
    }

    /**
     * Solution: Recursion
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param s
     * @return String
     */
    public String removeDuplicateLetters2(String s) {
        int[] count = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos))
                pos = i;
            if (--count[s.charAt(i) - 'a'] == 0)
                break;
        }
        return s.length() == 0 ? ""
                : s.charAt(pos) + removeDuplicateLetters2(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }

    public static void main(String[] args) {
        System.out.println("316. Remove Duplicate Letters [medium]");
        LC0316_RemoveDuplicateLetters solution = new LC0316_RemoveDuplicateLetters();
        String[] inputs = { "bcabc", "cbacdcbc" };
        String[] answers = { "abc", "acdb" };
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Example " + (i + 1) + ":");
            System.out.println("Input: s = \"" + inputs[i] + "\"");
            System.out.println("Output: \"" + solution.removeDuplicateLetters1(inputs[i]) + "\"");
            System.out.println("Answer: \"" + answers[i] + "\"");
            System.out.println();
        }
    }

}
