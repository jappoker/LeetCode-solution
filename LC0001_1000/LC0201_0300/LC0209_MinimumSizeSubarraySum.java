package LC0001_1000.LC0201_0300;

/**
 * 209. Minimum Size Subarray Sum [medium]
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
 * of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * 
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * 
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * 
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * 
 * Constraints:
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 */
public class LC0209_MinimumSizeSubarraySum {

    /**
     * Solution: Two Pointers
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param target
     * @param nums
     * @return int
     */

    public int minSubArrayLen(int target, int[] nums) {
        // corner case
        if(nums == null || nums.length == 0) return 0;
        int sum = 0;
        int i = 0;
        int result = Integer.MAX_VALUE;

        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            while(sum >= target){
                result = Math.min(result, j - i + 1);
                sum-=nums[i++];
            }
        }
        return result == Integer.MAX_VALUE? 0 : result;
    }

    /**
     * Solution: Binary Search
     * Time Complexity: O(NlogN)
     * Space Complexity: O(1)
     * @param target
     * @param nums
     * @return int
     */

    public int minSubArrayLen2(int target, int[] nums) {
        // corner case
        if(nums == null || nums.length == 0) return 0;
        int result = Integer.MAX_VALUE;
        int[] sums = new int[nums.length + 1];
        for(int i = 1; i < sums.length; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }
        for(int i = 0; i < sums.length; i++){
            int right = binarySearch(i+1, sums.length-1, sums[i] + target, sums);
            if(right == sums.length) break;
            result = Math.min(result, right - i);
        }
        return result == Integer.MAX_VALUE? 0 : result;
    }
    private int binarySearch(int left, int right, int target, int[] sums){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(sums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println("209. Minimum Size Subarray Sum [medium]");
        LC0209_MinimumSizeSubarraySum solution = new LC0209_MinimumSizeSubarraySum();
        int[][] inputs = {
            {2, 3, 1, 2, 4, 3},
            {1, 4, 4},
            {1, 1, 1, 1, 1, 1, 1}
        };
        int[] targets = {7, 4, 11};
        int[] answers = {2, 1, 0};
        for(int i = 0; i < inputs.length; i++){
            int[] input = inputs[i];
            int target = targets[i];
            int answer = answers[i];
            System.out.println(solution.minSubArrayLen(target, input) == answer);
        }
    }
    
}
