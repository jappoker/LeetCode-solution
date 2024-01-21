package LC0001_1000.LC0701_0800;

/**
 * 0754. Reach a Number
 * https://leetcode.com/problems/reach-a-number/
 * 
 * You are standing at position 0 on an infinite number line. There is a goal at
 * position target.
 * 
 * On each move, you can either go left or right. During the n-th move (starting
 * from 1), you take n steps.
 * 
 * Return the minimum number of steps required to reach the destination.
 * 
 * Example 1:
 * Input: target = 3
 * Output: 2
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second step we step from 1 to 3.
 * 
 * Example 2:
 * Input: target = 2
 * Output: 3
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second move we step from 1 to -1.
 * On the third move we step from -1 to 2.
 */

public class LC0754_ReachANumber {

    /**
     * Solution: Math
     * Time Complexity: O(sqrt(target))
     * Space Complexity: O(1)
     * 
     * @param target
     * @return
     */
    public int reachNumber1(int target) {
        target = Math.abs(target);
        int sum = 0, step = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }

    /**
     * Solution: Binary Search
     * Time Complexity: O(log(target))
     * Space Complexity: O(1)
     * 
     * @param target
     * @return
     */
    public int reachNumber3(int target) {
        if (target < 0) {
            target *= -1;
        }
        int start = 1;
        int end = target;
        int res = 0;
        long position = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println(mid);
            long sum = (long) mid * (mid + 1) / 2;
            if (sum >= target) {
                position = sum;
                res = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        int diff = (int) (position - target);
        if (diff % 2 != 0) {
            if ((res + 1) % 2 != 0)
                res++;
            else
                res += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("754. Reach a Number [medium]");
        LC0754_ReachANumber s = new LC0754_ReachANumber();
        System.out.println(s.reachNumber1(3)); // 2
        System.out.println(s.reachNumber1(2)); // 3

        System.out.println(s.reachNumber3(3)); // 2
        System.out.println(s.reachNumber3(2)); // 3
    }

}