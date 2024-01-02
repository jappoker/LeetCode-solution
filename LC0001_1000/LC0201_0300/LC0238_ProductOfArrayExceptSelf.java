package LC0001_1000.LC0201_0300;

import java.util.Arrays;

/** 
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * 
 * Constraints:
 * 2 <= nums.length <= 10^5
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class LC0238_ProductOfArrayExceptSelf {

    /**
     * Solution1: left product * right product
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * @param nums
     * @return ans
     */
    public int[] productExceptSelf1(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) return nums;

        int n = nums.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];

        for(int i = 0; i < n; i++){
            leftProduct[i] = i==0?1:leftProduct[i-1]*nums[i-1];
        }
        for(int i = n - 1; i>= 0; i--){
            rightProduct[i] = i ==n-1?1:rightProduct[i+1]*nums[i+1];
        }
        for(int i = 0; i < n; i++){
            nums[i] = leftProduct[i] * rightProduct[i];
        }
        return nums;
    }

    /**
     * Solution2: O(1) space approach
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param nums
     * @return ans
     */
    public int[] productExceptSelf2(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) return nums;

        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;
        for(int i = 1; i < n; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int r = 1;
        for(int i = n-1; i >= 0; i--){
            ans[i] = ans[i] * r;
            r *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("238. Product of Array Except Self [medium]");

        LC0238_ProductOfArrayExceptSelf s = new LC0238_ProductOfArrayExceptSelf();
        int[] nums = new int[]{1,2,3,4};
        int[] ans = s.productExceptSelf2(nums);
        System.out.println(Arrays.toString(ans)); // [24,12,8,6]

        nums = new int[]{-1,1,0,-3,3};
        ans = s.productExceptSelf2(nums);
        System.out.println(Arrays.toString(ans)); // [0,0,9,0,0]
    }
    
}
