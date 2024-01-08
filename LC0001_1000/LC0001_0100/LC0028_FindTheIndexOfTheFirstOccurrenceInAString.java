package LC0001_1000.LC0001_0100;

/**
 * 28. Find the Index of the First Occurrence in a String
 * 
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * 
 */
public class LC0028_FindTheIndexOfTheFirstOccurrenceInAString {

    /**
     * Solution: Built-in api
     * Time Complexity: O((N-L)L)
     * Space Complexity: O(1)
     * @param haystack
     * @param needle
     * @return int
     */
    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * Solution: Two Pointers
     * Time Complexity: O((N-L)L)
     * Space Complexity: O(1)
     * @param haystack
     * @param needle
     * @return int
     */
    public int strStr2(String haystack, String needle){
        if(haystack.length() ==0 || needle.length() ==0 ) return -2;

        for(int i = 0; i < haystack.length()-needle.length()+1; i++){
            int j;
            for(j = 0; j < needle.length(); j++){
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }

    /**
     * Solution: Rabin Karp - Rolling Hash
     * Time Complexity: O((N-L)L)
     * Space Complexity: O(1)
     * @param haystack
     * @param needle
     * @return int
     */
    public int strStr3(String haystack, String needle){
        int L = needle.length(), n = haystack.length();
        if(L > n) return -1;

        long h = 0, ref_h = 0, aL = 1;
        int base = 26, modulus = (int)Math.pow(2, 31);
        for(int i = 0; i < L; i++){
            h = (h * base + haystack.charAt(i)) % modulus;
            ref_h = (ref_h * base + needle.charAt(i)) % modulus;
            aL = (aL * base) % modulus;
        }
        if(h == ref_h) return 0;

        for(int start = 1; start < n - L + 1; start++){
            h = (h * base - haystack.charAt(start - 1) * aL + haystack.charAt(start + L - 1)) % modulus;
            if(h == ref_h) return start;
        }
        return -1;
    }

    /**
     * Solution: Knuth-Morris-Pratt Algorithm
     * Time Complexity: O(N+L)
     * Space Complexity: O(L)
     * @param haystack
     * @param needle
     * @return int
     */
    public int strStr4(String haystack, String needle){
        int L = needle.length(), n = haystack.length();
        if(L > n) return -1;
        if(L == 0) return 0;

        int[] pi = new int[L];
        for(int i = 1, j = 0; i < L; i++){
            while(j > 0 && needle.charAt(i) != needle.charAt(j)) j = pi[j-1];
            if(needle.charAt(i) == needle.charAt(j)) j++;
            pi[i] = j;
        }

        for(int i = 0, j = 0; i < n; i++){
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)) j = pi[j-1];
            if(haystack.charAt(i) == needle.charAt(j)) j++;
            if(j == L) return i - L + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("28. Find the Index of the First Occurrence in a String [easy]");
        LC0028_FindTheIndexOfTheFirstOccurrenceInAString solution = new LC0028_FindTheIndexOfTheFirstOccurrenceInAString();
        String[][] inputs = {
            {"hello", "ll"},
            {"aaaaa", "bba"},
            {"", ""},
            {"", "a"},
            {"a", ""},
            {"mississippi", "issip"},
        };
        int[] answers = {2, -1, 0, -1, 0, 4};
        for(int i = 0; i < inputs.length; i++){
            String[] input = inputs[i];
            System.out.println(solution.strStr4(input[0], input[1]) == answers[i]);
        }
    }
}
