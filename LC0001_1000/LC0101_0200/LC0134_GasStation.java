package LC0001_1000.LC0101_0200;

/**
 * 134. Gas Station
 * https://leetcode.com/problems/gas-station/
 * 
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1. If there exists a solution, it is guaranteed to be unique
 * 
 * Example 1:
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * 
 * Example 2:
 * Input: gas = [2,3,4], cost = [3,4,3]
 * Output: -1
 * 
 * Example 3:
 * Input: gas = [5,1,2,3,4], cost = [4,4,1,5,1]
 * Output: 4
 * 
 * Constraints:
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 10^4
 * 0 <= gas[i], cost[i] <= 10^4
 */

public class LC0134_GasStation {

    /**
     * Solution1: Greedy
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param gas
     * @param cost
     * @return start index
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int total = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0){
                tank = 0;
                start = i + 1;
            }
        }
        return total < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        System.out.println("134. Gas Station [medium]");
        LC0134_GasStation ss = new LC0134_GasStation();
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(ss.canCompleteCircuit(gas, cost)); // 3

        gas = new int[]{2,3,4};
        cost = new int[]{3,4,3};
        System.out.println(ss.canCompleteCircuit(gas, cost)); // -1
    }
}
