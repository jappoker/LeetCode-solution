package LC0001_1000.LC0001_0100;

/**
 * 26. Remove Duplicates from Sorted Array
 * 
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * 
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
 * 
 * It does not matter what you leave beyond the first k elements.
 * 
 * Return k after placing the final result in the first k slots of nums.
 * 
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * 
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * 
 */

public class LC0026_RemoveDuplicatesFromSortedArray {

    /**
     * Solution: Two Pointers
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param nums: an array of integers
     * @return: return length of new array
     */
    public int removeDuplicates(int[] nums) {
        // cc
        if(nums == null || nums.length == 0) return 0;
        // two pointers
        int i = 1; // skip the first element because it is always unique
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i-1]) nums[i++] = nums[j];
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println("26. Remove Duplicates from Sorted Array [easy]");
        LC0026_RemoveDuplicatesFromSortedArray solu = new LC0026_RemoveDuplicatesFromSortedArray();
        int[] nums = new int[]{1,1,2};
        int len = solu.removeDuplicates(nums);
        System.out.println(len); // 2
        System.out.println(java.util.Arrays.toString(java.util.Arrays.copyOfRange(nums, 0, len)));
    }
}
