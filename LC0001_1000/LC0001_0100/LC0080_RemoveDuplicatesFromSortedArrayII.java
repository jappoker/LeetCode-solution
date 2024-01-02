package LC0001_1000.LC0001_0100;

/**
 * 80. Remove Duplicates from Sorted Array II
 * 
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * 
 * Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * 
 * Example 2:
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 */
public class LC0080_RemoveDuplicatesFromSortedArrayII {

    /**
     * Solution: Two Pointers
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param nums: an array of integers
     * @return: return length of new array
     */
    public int removeDuplicates(int[] nums) {
        // corner case
        if(nums == null) return 0;
        if(nums.length <= 2) return nums.length;
        
        int n = nums.length;
        int i = 2; // skip the first two elements because they are always unique
        for(int j = 2; j < n; j++){
            if(nums[j]!= nums[i-2]) nums[i++] = nums[j];
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println("80. Remove Duplicates from Sorted Array II [medium]");
        LC0080_RemoveDuplicatesFromSortedArrayII solu = new LC0080_RemoveDuplicatesFromSortedArrayII();
        int[] nums = new int[]{1,1,1,2,2,3};
        int len = solu.removeDuplicates(nums);
        System.out.println(len); // 5
        System.out.println(java.util.Arrays.toString(java.util.Arrays.copyOfRange(nums, 0, len)));
    }
}
