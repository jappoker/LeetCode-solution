package LC0001_1000.LC0001_0100;

/**
 * 55. Jump Game
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * 
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * 
 * Constraints:
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i] <= 10^5
 * 
 * Follow up: Can you reach the last index if you can only jump through nums[i] >= i jumps?
 * 
 * This Java solution includes 3 methods:
 * canJump1: Greedy
 * canJump2: Greedy
 * canJump3: DP
 */

public class LC0055_JumpGame {
    /**
     * Solution: Greedy
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param nums: an array of non-negative integers
     * @return: true if you can reach the last index, or false
     */
    public boolean canJump1(int[] nums) {
        // corner case
        if(nums == null || nums.length == 0) return false;

        int canReach = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i > canReach) return false;
            canReach = Math.max(canReach, i + nums[i]);
        }
        return true;
    }

    /**
     * Solution: Greedy
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param nums: an array of non-negative integers
     * @return: true if you can reach the last index, or false
     */
    public boolean canJump2(int[] nums) {
        // corner case
        if(nums == null || nums.length == 0) return false;

        int maxRange = 0;
        for(int i = 0; i <= maxRange; i++){
            maxRange = Math.max(maxRange, i + nums[i]);
            if (maxRange >= nums.length - 1) return true;
        }
        return false;
    }

    /**
     * Solution: DP
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * @param nums: an array of non-negative integers
     * @return: true if you can reach the last index, or false
     */
    public boolean canJump3(int[] nums) {
        // corner case
        if(nums == null || nums.length == 0) return false;

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            if(dp[i - 1] < i) return false;
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        LC0055_JumpGame jumpGame = new LC0055_JumpGame();
        System.out.println(jumpGame.canJump1(new int[]{2,3,1,1,4})); // true
        System.out.println(jumpGame.canJump1(new int[]{3,2,1,0,4})); // false
        System.out.println(jumpGame.canJump2(new int[]{2,3,1,1,4})); // true
        System.out.println(jumpGame.canJump2(new int[]{3,2,1,0,4})); // false
        System.out.println(jumpGame.canJump3(new int[]{2,3,1,1,4})); // true
        System.out.println(jumpGame.canJump3(new int[]{3,2,1,0,4})); // false
    }
}
