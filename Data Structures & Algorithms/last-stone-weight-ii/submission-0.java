class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int stone : stones) {
            totalSum += stone;
        }

        // We want to partition the stones into two subsets with sums as close as possible.
        // This reduces to finding a subset with a sum closest to totalSum / 2.
        int target = totalSum / 2;
        int[] dp = new int[target + 1];

        for (int stone : stones) {
            // Iterate backwards to avoid using the same stone multiple times (0/1 Knapsack)
            for (int j = target; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }

        // One subset has sum dp[target], the other has (totalSum - dp[target]).
        // The difference is (totalSum - dp[target]) - dp[target].
        return totalSum - 2 * dp[target];
    }
}
