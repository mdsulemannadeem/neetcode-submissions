class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // Track the max profit in 3 possible states at the end of each day:
        int hold = -prices[0]; // Currently holding a NeetCoin
        int sold = 0;          // Just sold a NeetCoin today (triggers cooldown tomorrow)
        int rest = 0;          // Not holding a NeetCoin and not in cooldown (ready to buy)

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            // Keep holding, or buy today after resting yesterday
            hold = Math.max(prevHold, prevRest - prices[i]);
            
            // Sell today after holding yesterday
            sold = prevHold + prices[i];
            
            // Keep resting, or finish cooldown from selling yesterday
            rest = Math.max(prevRest, prevSold);
        }

        // Max profit will always end without holding a coin
        return Math.max(sold, rest);
    }
}
