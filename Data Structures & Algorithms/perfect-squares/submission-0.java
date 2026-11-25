class Solution {
    public int numSquares(int n) {
          int[] dp = new int[n + 1];
        
        // Initialize with a value larger than any possible answer
        Arrays.fill(dp, n + 1);
        
        // Base case: 0 requires 0 perfect squares
        dp[0] = 0;
        
        // Build up the minimum counts for every number from 1 to n
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        
        return dp[n];
    }
}