package LC0001_1000.LC0101_0200;

import java.util.Arrays;

/**
 * 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 * Given an array of integers numbers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * 
 * Return the indices of the two numbers (1-indexed) as an integer array answer
 * of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
 * 
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.
 * 
 * Example1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * 
 * Example2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * 
 * Example3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 */

public class LC0167_TwoSumII {

    /**
     * Solution1: Two Pointers
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * @param numbers
     * @param target
     * @return indices of the two numbers such that they add up to target
     */

    public int[] twoSum(int[] numbers, int target) {
        // corner case
        if (numbers == null || numbers.length <= 1)
            return new int[] { -1, -1 };

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target)
                return new int[] { left + 1, right + 1 };
            else if (numbers[left] + numbers[right] < target)
                left++;
            else
                right--;
        }
        return new int[] { -1, -1 };
    }

    /**
     * Solution2: Binary Search
     * Time Complexity: O(NlogN)
     * Space Complexity: O(1)
     * 
     * @param numbers
     * @param target
     * @return indices of the two numbers such that they add up to target
     */

    public int[] twoSum2(int[] numbers, int target) {
        // corner case
        if (numbers == null || numbers.length <= 1)
            return new int[] { -1, -1 };

        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            int complement = target - numbers[i];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] == complement)
                    return new int[] { i + 1, mid + 1 };
                else if (numbers[mid] < complement)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        System.out.println("167. Two Sum II - Input array is sorted [medium]");
        LC0167_TwoSumII ss = new LC0167_TwoSumII();
        // Test case 1:
        int[] numbers = new int[] { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(ss.twoSum(numbers, target))); // Expected output: [1,2]

        // Test case 2:
        numbers = new int[] { 2, 3, 4 };
        target = 6;
        System.out.println(Arrays.toString(ss.twoSum(numbers, target))); // Expected output: [1,3]
    }
}
