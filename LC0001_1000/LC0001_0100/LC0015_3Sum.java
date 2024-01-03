package LC0001_1000.LC0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example1:
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
 * 
 * Example2:
 * Input: nums = [] Output: []
 * 
 * Example3:
 * Input: nums = [0] Output: []
 * 
 * Constraints:
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */

public class LC0015_3Sum {
    
    /**
     * Solution1: Sort + Two Pointers
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     * 
     * @param nums
     * @return all the triplets such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans=new HashSet<>();
        for(int i = 0; i < nums.length-2; i++){
            int p1 = i+1;
            int p2 = nums.length-1;
            if(nums[i] > 0) break;
            while(p1 < p2){
                int sum = nums[i]+nums[p1]+nums[p2];
                if(sum == 0){
                    ArrayList<Integer> sp = new ArrayList<>();
                    sp.add(nums[i]);
                    sp.add(nums[p1]);
                    sp.add(nums[p2]);
                    ans.add(sp);
                    p1++;
                }
                else if(sum < 0) p1++;
                else p2--;
            }
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        System.out.println("15. 3Sum [medium]");
        // Testcase1
        int[] nums1 = new int[] { -1, 0, 1, 2, -1, -4 };
        LC0015_3Sum s = new LC0015_3Sum();
        List<List<Integer>> ans1 = s.threeSum(nums1);
        System.out.println(ans1); // [[-1,-1,2],[-1,0,1]]
        // Testcase2
        int[] nums2 = new int[] {};
        List<List<Integer>> ans2 = s.threeSum(nums2);
        System.out.println(ans2); // []
        // Testcase3
        int[] nums3 = new int[] { 0 };
        List<List<Integer>> ans3 = s.threeSum(nums3);
        System.out.println(ans3); // []
    }
}
