class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        // suffixSum[i] stores the total stones from pile i to the end
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        // dp[i][m] = max stones the current player can get starting at index i with parameter M = m
        int[][] dp = new int[n][n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                // If the current player can take all remaining piles, take them all
                if (i + 2 * m >= n) {
                    dp[i][m] = suffixSum[i];
                } else {
                    // Try taking X piles (1 <= X <= 2*M) and minimize what the opponent gets next
                    for (int x = 1; x <= 2 * m; x++) {
                        int opponentMax = dp[i + x][Math.max(m, x)];
                        dp[i][m] = Math.max(dp[i][m], suffixSum[i] - opponentMax);
                    }
                }
            }
        }
        
        // Alice starts at index 0 with M = 1
        return dp[0][1];
    }
}
