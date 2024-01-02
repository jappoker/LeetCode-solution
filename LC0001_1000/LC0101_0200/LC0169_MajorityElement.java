package LC0001_1000.LC0101_0200;

import java.util.Arrays;

/** 
 * 169. Majority Element [easy]
 * 
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than n / 2 times.
 * You may assume that the majority element always exists in the array.
 * 
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -231 <= nums[i] <= 231 - 1
 */
public class LC0169_MajorityElement {

    /**
     * Solution: Sorting
     * Time Complexity: O(NlogN)
     * Space Complexity: O(1)
     * 
     * @param nums
     * @return majority element
     */
    public int majorityElement1(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) return -1;

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Solution: Boyer-Moore Voting Algorithm
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param nums
     * @return majority element
     */
    public int majorityElement2(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) return -1;

        int num = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                num = nums[i];
                count++;
            } else if(num == nums[i]) count++;
            else count--;
        }
        return num;
    }
    
    public static void main(String[] args) {
        System.out.println("169. Majority Element [easy]");
        LC0169_MajorityElement solu = new LC0169_MajorityElement();
        int[] nums = new int[]{3,2,3};
        System.out.println(solu.majorityElement2(nums)); // 3
        nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(solu.majorityElement2(nums)); // 2
    }
}
