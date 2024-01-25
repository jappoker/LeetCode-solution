package LC0001_1000.LC0201_0300;

import java.util.HashSet;

/** 
 * 0202. Happy Number
 * https://leetcode.com/problems/happy-number/
 * 
 * Write an algorithm to determine if a number n is happy.
 * 
 * A happy number is a number defined by the following process:
 *  - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * - Those numbers for which this process ends in 1 are happy.
 * 
 * Return true if n is a happy number, and false if not.
 * 
 * Example 1:
 * Input: n = 19
 * Output: true
 * 
 * Example 2:
 * Input: n = 2
 * Output: false
 */

public class LC0202_HappyNumber {

    /**
     * Solution: HashSet
     * Time Complexity: O(logn)
     * Space Complexity: O(logn)
     * 
     * @param n
     * @return
     */

    public boolean isHappy1(int n) {
        HashSet<Integer> set = new HashSet<>();
        while( n!= 1){
            int k = next(n);
            if(!set.add(k)) return false;
            n = k;
        }
        return true;
    }

    /**
     * Solution: Floyd Cycle Detection
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     * 
     * @param n
     * @return
     */

    public boolean isHappy2(int n) {
        int s = n;
        int f = next(s);
        while(f!= 1 && f != s){
            s = next(s);
            f = next(next(f));
        }
        return f == 1;
    }

    private int next(int n){
        int res = 0;
        while(n > 0){
            int t = n % 10;
            res += t * t;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("LC 202 HappyNumber [Easy]");
        LC0202_HappyNumber ss = new LC0202_HappyNumber();
        System.out.println(ss.isHappy1(19)); //true
        System.out.println(ss.isHappy2(19)); //true

        System.out.println(ss.isHappy1(2)); //false
        System.out.println(ss.isHappy2(2)); //false
    }
}
