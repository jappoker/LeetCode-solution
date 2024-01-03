package LC0001_1000.LC0101_0200;

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 * 
 * Given a string s, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * 
 */
public class LC0125_ValidPalindrome {

    /**
     * Solution1: Two Pointers
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param s
     * @return true if palindrome
     */
    public boolean isPalindrome1(String s) {
        int n = s.length();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            while (i < j && !check(s.charAt(i)))
                i++;
            while (i < j && !check(s.charAt(j)))
                j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }
        return true;
    }

    private boolean check(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    /**
     * Solution2: Extra Space
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * @param s
     * @return true if palindrome
     */
    public boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                sb.append(Character.toLowerCase(c));
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println("125. Valid Palindrome [easy]");
        LC0125_ValidPalindrome ss = new LC0125_ValidPalindrome();

        // Test case 1: Palindrome with only letters
        System.out.println(ss.isPalindrome2("racecar")); // Expected output: true

        // Test case 2: Palindrome with letters and digits
        System.out.println(ss.isPalindrome2("A man, a plan, a canal: Panama")); // Expected output: true

        // Test case 3: Not a palindrome
        System.out.println(ss.isPalindrome2("hello")); // Expected output: false

        // Test case 4: Empty string
        System.out.println(ss.isPalindrome2("")); // Expected output: true

        // Test case 5: String with only special characters
        System.out.println(ss.isPalindrome2("!!!")); // Expected output: true
    }

}
