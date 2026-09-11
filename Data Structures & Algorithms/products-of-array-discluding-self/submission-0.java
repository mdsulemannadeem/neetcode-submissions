class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        
        // Step 1: Calculate Prefix Product
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate Suffix Product and Combine
        int suffix = 1; // Directly use variable instead of array
        for (int i = n - 1; i >= 0; i--) {
            output[i] = prefix[i] * suffix;
            suffix *= nums[i];
        }

        return output; 
    }
}  
