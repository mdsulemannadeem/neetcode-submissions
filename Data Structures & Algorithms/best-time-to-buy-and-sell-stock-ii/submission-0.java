class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        // Loop through prices starting from the second day
        for (int i = 1; i < prices.length; i++) {
            // If the price today is higher than yesterday, capture the profit
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}