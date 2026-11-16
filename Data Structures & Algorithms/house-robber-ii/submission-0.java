class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        // Edge case: only one house to rob
        if (n == 1) {
            return nums[0];
        }
        
        // Scenario 1: Rob houses from index 0 to n - 2 (exclude last house)
        int maxExcludeLast = robLinear(nums, 0, n - 2);
        
        // Scenario 2: Rob houses from index 1 to n - 1 (exclude first house)
        int maxExcludeFirst = robLinear(nums, 1, n - 1);
        
        return Math.max(maxExcludeLast, maxExcludeFirst);
    }
    
    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // Max money up to two houses back
        int prev1 = 0; // Max money up to the previous house
        
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}
