package LC0001_1000.LC0201_0300;

import java.util.Arrays;

/**
 * 274. H-Index
 * https://leetcode.com/problems/h-index/
 * 
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper,
 * return compute the researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each,
 * and the other n − h papers have no more than h citations each.
 * 
 * If there are several possible values for h, the maximum one is taken as the h-index.
 * 
 * Example 1:
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * 
 * Example 2:
 * Input: citations = [1,3,1]
 * Output: 1
 * 
 * Constraints:
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 */
public class LC274_HIndex {

    /**
     * Solution: Sort
     * Time Complexity: O(NlogN)
     * Space Complexity: O(1)
     * @param citations
     * @return int h
     */
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i = 1;
        int n = citations.length;
        while(i <= n){
            int j = n - i;
            h = Math.max(h, Math.min(i, citations[j]));
            i++;
        }
        return h;
    }

    /**
     * Solution: Bucket Sort
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * @param citations
     * @return int h
     */
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++; // all papers with more than n citations are put into the same bucket
            } else {
                buckets[c]++; // papers with citations c are put into bucket c
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("274. H-Index [medium]");
        LC274_HIndex inst = new LC274_HIndex();
        int[] citations = new int[]{3,0,6,1,5};
        System.out.println(inst.hIndex1(citations)); // 3
        System.out.println(inst.hIndex2(citations)); // 3

        citations = new int[]{1,3,1};
        System.out.println(inst.hIndex1(citations)); // 1
        System.out.println(inst.hIndex2(citations)); // 1
    }
}
