package LC0001_1000.LC0101_0200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence [hard]
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 * 
 * Example 1:
 * 
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * 
 * Example 2:
 * 
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */

public class LC0128_LongestConsecutiveSequence {

    /**
     * Solution 1: Sorting
     * 
     * Time Complexity: O(NlogN) // Arrays.sort() is O(NlogN)
     * Space Complexity: O(1)
     * 
     * @param nums
     * @return the length of the longest consecutive elements sequence
     */
    public int longestConsecutive1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int result = 0;
        int cur = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1] + 1) cur++;
            else if (nums[i] != nums[i-1]) cur = 1;
            result = Math.max(result, cur);
        }
        return Math.max(result, cur);
    }

    /**
     * Solution 2: HashSet and Intelligent Sequence Building
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * @param nums
     * @return the length of the longest consecutive elements sequence
     */
    public int longestConsecutive2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int result = 0;
        for(int num : nums){
            if(!set.contains(num - 1)){
                int cur = 1;
                while(set.contains(num + 1)){
                    cur++;
                    num++;
                }
                result = Math.max(result, cur);
            }
        }
        return result;
    }

    /**
     * Solution 3: Union Find
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * @param nums
     * @return the length of the longest consecutive elements sequence
     */
    // TODO: Union Find
    

    public static void main(String[] args) {
        System.out.println("128. Longest Consecutive Sequence [Medium]");
        LC0128_LongestConsecutiveSequence obj = new LC0128_LongestConsecutiveSequence();
        System.out.println(obj.longestConsecutive1(new int[]{100,4,200,1,3,2}));
        System.out.println(obj.longestConsecutive2(new int[]{100,4,200,1,3,2}));
        // System.out.println(obj.longestConsecutive3(new int[]{100,4,200,1,3,2}));
    }
    
}
