class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If target is out of reach or (totalSum + target) is odd, no valid partition exists
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0) {
            return 0;
        }

        int subsetSum = (totalSum + target) / 2;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // One way to form sum 0: pick no elements

        for (int num : nums) {
            // Iterate backwards to ensure each number is used at most once (0/1 Knapsack)
            for (int i = subsetSum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[subsetSum];
    }
}
