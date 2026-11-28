class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j] = max score difference (current player - opponent) for piles[i..j]
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        // len is the subarray length (from 2 up to n)
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int pickLeft = piles[i] - dp[i + 1][j];
                int pickRight = piles[j] - dp[i][j - 1];
                dp[i][j] = Math.max(pickLeft, pickRight);
            }
        }

        return dp[0][n - 1] > 0;
    }
}
