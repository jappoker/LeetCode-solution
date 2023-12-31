package LC0001_1000.LC0001_0100;

/**
 * 45. Jump Game II
 * 
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * You can assume that you can always reach the last index.
 * 
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * 
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * 
 * Constraints:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 * 
 * This Java solution includes 2 methods:
 * jump1: DP, Time: O(N^2)
 *        `dp[i]` represents the minimum number of jumps to reach the index i;
 *        dp[i] = dp[j] + 1, where j < i and j + nums[j] >= i
 * jump2: Greedy, Time: O(N)
 *        We use 3 variables to record the information:
 *         - `maxPos` represents the maximum position we can reach,
 *         - `end` represents the end of the current jump,
 *         - `steps` represents the number of jumps we have used,
 * 
 */

public class LC0045_JumpGameII {
    /**
     * Solution: DP
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     * @param nums, an array of non-negative integers
     * @return int, the minimum number of jumps to reach the last index
     */
    public int jump1(int[] nums) {
        // corner case
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int maxReach = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n && maxReach < n; i++){
            int steps = nums[i];
            maxReach = Math.max(steps + i, maxReach);
            for(int j = i + 1; j < i + 1 + steps && j < n; j++){
                if(dp[j] == 0) dp[j] = dp[i] + 1;
            }
        }
        return dp[n-1];
    }
    // Example: nums = [2, 3, 1, 1, 4]
    // i = 0: dp = [0, 1, 1, 0, 0];
    // i = 1: dp = [0, 1, 1, 2, 2]; finished

    /**
     * Solution: Greedy
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param nums, an array of non-negative integers
     * @return int, the minimum number of jumps to reach the last index
     */

    public int jump2(int[] nums) {
        int n = nums.length;
        int maxPos = 0, end = 0, steps = 0;
        for(int i = 0; i < n - 1; i++){
            if(maxPos >= i){
                maxPos = Math.max(maxPos, i + nums[i]);
                if(i == end){
                    end = maxPos;
                    steps++;
                }
            }
        }
        return steps;
    }
    // Example: nums = [2, 3, 1, 1, 4]
    // i = 0: maxPos = 2, end = 0, steps = 0;
    // i = 1: maxPos = 4, end = 2, steps = 1; 
    // i = 2: maxPos = 4, end = 2, steps = 1;
    // i = 3: maxPos = 4, end = 4, steps = 2; finished

    public static void main(String[] args) {
        LC0045_JumpGameII jumpGameII = new LC0045_JumpGameII();
        System.out.println(jumpGameII.jump1(new int[]{2,3,1,1,4})); // 2
        System.out.println(jumpGameII.jump2(new int[]{2,3,1,1,4})); // 2
    }
}
