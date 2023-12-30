package LC0001_1000.LC0001_0100;

import java.util.Arrays;

/**
 * 27. Remove Element
 * 
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * 
 * Example 1:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * 
 * Example 2:
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * 
 * Constraints:
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */

public class LC0027_RemoveElement {

    /**
     * Solution: Two Pointers
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param nums: an array of integers
     * @param val: an integer, value need to be removed
     * @return: return length of new array
     */
    public int removeElement(int[] nums, int val) {
        // corner case
        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] != val) nums[left++] = nums[right];
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println("27. Remove Element [easy]");
        LC0027_RemoveElement solu = new LC0027_RemoveElement();
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        int len = solu.removeElement(nums, val);
        System.out.println(len);
        System.out.println(java.util.Arrays.toString(Arrays.copyOfRange(nums, 0, len)));
    }
}
