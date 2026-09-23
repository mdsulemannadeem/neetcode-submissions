class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        
        // Find maximum element for start and sum for end
        for (int i = 0; i < weights.length; i++) {
            start = Math.max(start, weights[i]);
            end += weights[i];
        }
        
        int ans = end;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canAchieve(weights, mid, days)) {
                ans = mid;     // Try a smaller capacity
                end = mid - 1;
            } else {
                start = mid + 1; // Need more capacity
            }
        }
        
        return ans;
    }
    
    private boolean canAchieve(int[] weights, int mid, int days) {
        int groups = 1; // Start with the first day/group
        int current = 0;
        
        for (int i = 0; i < weights.length; i++) {
            current += weights[i];
            if (current > mid) {
                groups++;
                current = weights[i];
            }
        }
        
        return groups <= days;
    }
}
