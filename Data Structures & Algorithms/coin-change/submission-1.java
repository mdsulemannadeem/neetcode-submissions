class Solution {
    public int coinChange(int[] coins, int amount) {
           int n = coins.length;

        // Step 1: Initialize DP table
        int[][] dp = new int[n + 1][amount + 1];

        // Step 2: Fill DP table
        // Base case: Initialize the table with a large value
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE - 1);
            dp[i][0] = 0; // 0 coins needed to form amount 0
        }

        // Step 3: Populate the table using the recursive relation
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Step 4: Return the result
        return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
    }
}