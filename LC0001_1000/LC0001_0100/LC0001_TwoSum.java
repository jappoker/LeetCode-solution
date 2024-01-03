package LC0001_1000.LC0001_0100;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 * 
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * 
 * Example2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Example3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 * Constraints:
 * 1. 2 <= nums.length <= 10^4
 * 2. -10^9 <= nums[i] <= 10^9
 * 3. -10^9 <= target <= 10^9
 * 4. Only one valid answer exists.
 * 
 */
public class LC0001_TwoSum {

    /**
     * Solution1: Brute Force
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     * 
     * @param nums
     * @param target
     * @return indices of the two numbers such that they add up to target
     */
    public int[] twoSum1(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length <= 1)
            return new int[] { -1, -1 };
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }
        return new int[] { -1, -1 };
    }

    /**
     * Solution2: Two Pass Hash Table
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * @param nums
     * @param target
     * @return indices of the two numbers such that they add up to target
     */
    public int[] twoSum2(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length <= 1)
            return new int[] { -1, -1 };
        HashMap<Integer, Integer> numIndiceMap = new HashMap<>(); // {key: nums[i], val: i}
        for (int i = 0; i < nums.length; i++) {
            numIndiceMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (numIndiceMap.containsKey(target - nums[i]) && numIndiceMap.get(target - nums[i]) != i) {
                return new int[] { i, numIndiceMap.get(target - nums[i]) };
            }
        }
        return new int[] { -1, -1 };
    }

    /**
     * Solution3: One Pass Hash Table
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * @param nums
     * @param target
     * @return indices of the two numbers such that they add up to target
     */
    public int[] twoSum3(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length <= 1)
            return new int[] { -1, -1 };
        HashMap<Integer, Integer> numIndiceMap = new HashMap<>(); // {key: nums[i], val: i}
        for (int i = 0; i < nums.length; i++) {
            if (numIndiceMap.containsKey(target - nums[i])) {
                return new int[] { numIndiceMap.get(target - nums[i]), i };
            }
            numIndiceMap.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    /**
     * Solution4: Sort and Two Pointers
     * Time Complexity: O(NlogN)
     * Space Complexity: O(N)
     * 
     * @param nums
     * @param target
     * @return indices of the two numbers such that they add up to target
     */
    public int[] twoSum4(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length <= 1)
            return new int[] { -1, -1 };
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        int left = 0, right = sortedNums.length - 1;
        while (left < right) {
            if (sortedNums[left] + sortedNums[right] == target) {
                int[] res = new int[2];
                int index = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == sortedNums[left] || nums[i] == sortedNums[right]) {
                        res[index++] = i;
                    }
                }
                return res;
            } else if (sortedNums[left] + sortedNums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        System.out.println("1. Two Sum [easy]");
        LC0001_TwoSum ss = new LC0001_TwoSum();

        // Test case 1: 
        System.out.println(Arrays.toString( ss.twoSum1(new int[] { 2, 7, 11, 15 }, 9))); // Expected output: [0,1]

        // Test case 2:
        System.out.println(Arrays.toString( ss.twoSum2(new int[] { 3, 2, 4 }, 6))); // Expected output: [1,2]

        // Test case 3:
        System.out.println(Arrays.toString( ss.twoSum3(new int[] { 3, 3 }, 6))); // Expected output: [0,1]

        // Test case 4:
        System.out.println(Arrays.toString( ss.twoSum4(new int[] { 3, 2, 3 }, 6))); // Expected output: [0,2]
    }

}
