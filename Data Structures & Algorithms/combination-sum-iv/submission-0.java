class Solution {
    public int combinationSum4(int[] nums, int target) {
         int[] dp = new int[target + 1];
        
        // Base case: 1 way to make sum 0 (use no elements)
        dp[0] = 1;
        
        // Build up the combinations for every target from 1 to target
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];

    }
}