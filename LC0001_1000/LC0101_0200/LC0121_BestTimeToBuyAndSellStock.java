package LC0001_1000.LC0101_0200;

/**
 * 121. Best Time to Buy and Sell Stock
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * 
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * 
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * 
 * Constraints:
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class LC0121_BestTimeToBuyAndSellStock {

    /**
     * Solution: One Pass
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param prices, an array of prices
     * @return int, max profit
     */
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int result = 0;
        for(int price: prices){
            buy = Math.min(price, buy);
            result = Math.max(result, price - buy);
        }
        return result;
    }
    // This solution is more like a greedy algorithm
    // We keep track of the minimum price we have seen so far
    // and we keep track of the max profit we can get by selling the stock at the current price
    
    // Most Straightforward Solution would be Brute Force: use two for loops to find the max profit
    // Time Complexity: O(N^2)

    public static void main(String[] args) {
        System.out.println("121. Best Time to Buy and Sell Stock [easy]");
        LC0121_BestTimeToBuyAndSellStock s = new LC0121_BestTimeToBuyAndSellStock();
        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(s.maxProfit(new int[]{7,6,4,3,1})); // 0
    }
}
