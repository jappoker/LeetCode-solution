package LC0001_1000.LC0101_0200;

/**
 * 122. Best Time to Buy and Sell Stock II
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 * 
 * Note: You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).
 * 
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * 
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * 
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * 
 * Constraints:
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 10^4
 */

public class LC0122_BestTimeToBuyAndSellStockII {
    /**
     * Solution: Peak Valley Approach
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;
        while(i < prices.length - 1){
            while(i < prices.length - 1 && prices[i] >= prices[i + 1]){
                i++;
            }
            valley = prices[i];
            while(i < prices.length - 1 && prices[i] <= prices[i + 1]){
                i++;
            }
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }

    /**
     * Solution: Simple One Pass
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]){
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
    // Example: [7,1,5,3,6,4]
    // i = 1, prices[i] - prices[i - 1] = -6, maxProfit = 0
    // i = 2, prices[i] - prices[i - 1] = 4, maxProfit = 4
    // i = 3, prices[i] - prices[i - 1] = -2, maxProfit = 4
    // i = 4, prices[i] - prices[i - 1] = 3, maxProfit = 7
    // i = 5, prices[i] - prices[i - 1] = -2, maxProfit = 7


    /**
     * Solution: One Pass (Greedy)
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for(int price: prices){
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price);
        }
        return sell;
    }
    // This solution is more like a greedy algorithm
    // We keep track of the minimum price we have seen so far
    // and we keep track of the max profit we can get by selling the stock at the current price
    // For exampe: [7,1,5,3,6,4]
    // i = 0, price = 7, sell - price = -inf, buy = -7, buy + price = 0, sell = 0
    // i = 1, price = 1, sell - price = -1, buy = -1, buy + price = 0, sell = 0
    // i = 2, price = 5, sell - price = -1, buy = -1, buy + price = 4, sell = 4
    // i = 3, price = 3, sell - price = 1, buy = 1, buy + price = 4, sell = 4
    // i = 4, price = 6, sell - price = 1, buy = 1, buy + price = 7, sell = 7
    // i = 5, price = 4, sell - price = 3, buy = 3, buy + price = 7, sell = 7

    
    public static void main(String[] args) {
        System.out.println("122. Best Time to Buy and Sell Stock II [medium]");
        LC0122_BestTimeToBuyAndSellStockII s = new LC0122_BestTimeToBuyAndSellStockII();
        System.out.println(s.maxProfit1(new int[]{7,1,5,3,6,4})); // 7
        System.out.println(s.maxProfit1(new int[]{1,2,3,4,5})); // 4
        System.out.println(s.maxProfit1(new int[]{7,6,4,3,1})); // 0
        System.out.println(s.maxProfit2(new int[]{7,1,5,3,6,4})); // 7
        System.out.println(s.maxProfit2(new int[]{1,2,3,4,5})); // 4
        System.out.println(s.maxProfit2(new int[]{7,6,4,3,1})); // 0
        System.out.println(s.maxProfit3(new int[]{7,1,5,3,6,4})); // 7
        System.out.println(s.maxProfit3(new int[]{1,2,3,4,5})); // 4
        System.out.println(s.maxProfit3(new int[]{7,6,4,3,1})); // 0
    }
}
