package LC0001_1000.LC0201_0300;

import java.util.Arrays;

/**
 * 280. Wiggle Sort
 * https://leetcode.com/problems/wiggle-sort/
 * 
 * Given an integer array nums, reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * You may assume the input array always has a valid answer.
 * 
 * Example 1:
 * Input: nums = [3,5,2,1,6,4]
 * Output: [3,5,1,6,2,4]
 * 
 * Explanation: [1,6,2,5,3,4] is also accepted.
 * 
 * Example 2:
 * Input: nums = [6,6,5,6,3,8]
 * Output: [6,6,5,6,3,8]
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 104
 * It is guaranteed that there will be an answer for the given input nums.
 */
public class LC0280_WiggleSort {
    
    /**
     * Solution 1: Sort
     * Time Complexity: O(NlogN)
     * Space Complexity: O(1)
     * @param nums
     */
    public void wiggleSort1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    /**
     * Solution 2: One-pass Swap / Greedy
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param nums
     */
    public void wiggleSort2(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n-1; i++){
            if(i%2 == 0 && nums[i] > nums[i+1]) swap(nums, i , i+1);
            if(i%2 == 1 && nums[i] <= nums[i+1]) swap(nums, i, i+1);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("280. Wiggle Sort [medium]");
        LC0280_WiggleSort solution = new LC0280_WiggleSort();
        int[][] inputs = {
            {3,5,2,1,6,4},
            {6,6,5,6,3,8}
        };
        int[][] answers = {
            {3,5,1,6,2,4},
            {6,6,5,6,3,8}
        };
        for(int i = 0; i < inputs.length; i++){
            int[] input = inputs[i];
            solution.wiggleSort2(input);
            System.out.println(Arrays.equals(input, answers[i]));
        }
    }
}
