class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;  
        int high = 0; 
        
        // Find boundaries using a standard for loop
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > low) {
                low = nums[i];
            }
            high += nums[i];
        }
        
        int ans = high;
        
        // Binary search for the minimized maximum sum
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canSplit(nums, k, mid)) {
                ans = mid;      // Valid maximum sum, try to look for a smaller one
                high = mid - 1; 
            } else {
                low = mid + 1;  // Too small, increase the target
            }
        }
        
        return ans;
    }
    private boolean canSplit(int[] nums, int k, int targetMax) {
        int subarrayCount = 1;
        int currentSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (currentSum + nums[i] > targetMax) {
                subarrayCount++;
                currentSum = nums[i];
                
                if (subarrayCount > k) {
                    return false;
                }
            } else {
                currentSum += nums[i];
            }
        }
        
        return true;
    }
}
