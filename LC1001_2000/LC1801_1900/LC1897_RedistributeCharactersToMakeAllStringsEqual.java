package LC1001_2000.LC1801_1900;

/**
 * 1897. Redistribute Characters to Make All Strings Equal
 * 
 * You are given an array of strings words (0-indexed).
 * 
 * In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character from words[i] to any position in words[j].
 * 
 * Return true if you can make every string in words equal using any number of operations, and false otherwise.
 * 
 * Example 1:
 * Input: words = ["abc","aabc","bc"]
 * Output: true
 * 
 * Explanation: Move the first 'a' in words[1] to the front of words[2],
 * to make words[1] = "abc" and words[2] = "abc".
 * All the strings are now equal to "abc", so return true.
 * 
 * Example 2:
 * Input: words = ["ab","a"]
 * Output: false
 * 
 * Explanation: It is impossible to make all the strings equal using the operation.
 * 
 * Constraints:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * 
 * All strings in words consist of lowercase English letters.
 */
public class LC1897_RedistributeCharactersToMakeAllStringsEqual {

    /**
     * Solution: Counting
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param words: an array of strings
     * @return: return true if you can make every string in words equal using any number of operations, and false otherwise
     */
    public boolean makeEqual(String[] words) {
        // corner case
        if(words == null || words.length == 0) return true; // TODO: throw exception
        int n = words.length;
        int[] count = new int[26]; // count the frequency of each letter
        for(String word: words){   // count the letter frequency for each word
            for(char c: word.toCharArray()){
                count[c-'a']++; 
            }
        }
        for(int i = 0; i < 26; i++){
            if(count[i]%n != 0) return false; // if the frequency of any letter is not divisible by n, return false
        }
        return true;
    }

    public static void main(String[] args) {
        LC1897_RedistributeCharactersToMakeAllStringsEqual lc1897 = new LC1897_RedistributeCharactersToMakeAllStringsEqual();
        System.out.println(lc1897.makeEqual(new String[]{"abc","aabc","bc"})); // true
        System.out.println(lc1897.makeEqual(new String[]{"ab","a"})); // false
    }
}
