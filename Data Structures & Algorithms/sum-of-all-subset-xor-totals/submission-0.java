class Solution {
    public int subsetXORSum(int[] nums) {
        // Start backtracking from index 0 with an initial XOR total of 0
        return backtrack(nums, 0, 0);
    }
    
    private int backtrack(int[] nums, int index, int currentXor) {
        // Base case: if we have considered all elements, return the current XOR total
        if (index == nums.length) {
            return currentXor;
        }
        
        // Choice 1: Include the current element in the subset
        int include = backtrack(nums, index + 1, currentXor ^ nums[index]);
        
        // Choice 2: Exclude the current element from the subset
        int exclude = backtrack(nums, index + 1, currentXor);
        
        // Return the sum of both paths
        return include + exclude;
    }
}
