package LC0001_1000.LC0001_0100;

/**
 * 58. Length of Last Word [easy]
 * 
 * Given a string s consists of some words separated by spaces, return the length of the last word in the string.
 * If the last word does not exist, return 0.
 * 
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * 
 * Example 2:
 * Input: s = " "
 * Output: 0
 */

public class LC0058_LengthOfLastWord {

    /**
     * Solution: Built-in api
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param s
     * @return int
     */
    public int lengthOfLastWord1(String s) {
        String[] words = s.split(" ");
        if(words.length == 0) return 0;
        return words[words.length - 1].length();
    }

    /**
     * Solution: Two Pointers, from end to start
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param s
     * @return int
     */
    public int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--; // skip spaces
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    /**
        * Solution: from start to end
        * Time Complexity: O(N)
        * Space Complexity: O(1)
        * @param s
        * @return int
    */
    public int lengthOfLastWord3(String s) {
        int len = 0;
        int prev = 0;
        for(char c: s.toCharArray()){
            if (c == ' '){
                if (len!= 0){
                    prev = len;
                }
                len = 0;
            } else len ++;
        }
        return len==0?prev:len;
    }

    public static void main(String[] args) {
        System.out.println("58. Length of Last Word [easy]");
        LC0058_LengthOfLastWord solution = new LC0058_LengthOfLastWord();
        String[] inputs = {"Hello World", " "};
        int[] answers = {5, 0};
        for(int i = 0; i < inputs.length; i++){
            System.out.println("Example " + (i + 1) + ":");
            System.out.println("Input: s = \"" + inputs[i] + "\"");
            System.out.println("Output: " + solution.lengthOfLastWord1(inputs[i]));
            System.out.println("Output: " + solution.lengthOfLastWord2(inputs[i]));
            System.out.println("Answer: " + answers[i]);
            System.out.println();
        }
    }
    
}
