package LC0001_1000.LC0001_0100;

/**
 * 88. Merge Sorted Array
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 * 
 * Example:
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 * 
 * Constraints:
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 */

public class LC0088_MergeSortedArray {

    /**
     * Solution: Two Pointers
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param nums1: an array of integers, size m+n, sorted in ascending order
     * @param m: an integer, length of valid elements in nums1
     * @param nums2: an array of integers, size n, sorted in ascending order
     * @param n: an integer, length of valid elements in nums2
     * @return: nothing
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // corner case
        if(nums1 == null || nums2 == null) return;
        int i = m - 1;
        int j = n - 1;
        int cur = m + n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[cur--] = nums1[i--];
            } else {
                nums1[cur--] = nums2[j--];
            }
        }
        while(j>= 0) nums1[cur--] = nums2[j--];
    }

    public static void main(String[] args) {
        System.out.println("88. Merge Sorted Array [easy]");
        LC0088_MergeSortedArray solu = new LC0088_MergeSortedArray();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        solu.merge(nums1, 3, nums2, 3);
        System.out.println(java.util.Arrays.toString(nums1));
    }
}
