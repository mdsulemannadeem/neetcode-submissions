class Solution {
    public int trap(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int leftMax = 0; // Tracks the maximum height to the left
        int rightMax = 0; // Tracks the maximum height to the right
        int trappedWater = 0;

        while (start < end) {
            if (height[start] < height[end]) {
                // Update leftMax and calculate trapped water
                if (height[start] >= leftMax) {
                    leftMax = height[start];
                } else {
                    trappedWater += leftMax - height[start];
                }
                start++; // Move the left pointer forward
            } else {
                // Update rightMax and calculate trapped water
                if (height[end] >= rightMax) {
                    rightMax = height[end];
                } else {
                    trappedWater += rightMax - height[end];
                }
                end--; // Move the right pointer backward
            }
        }

        return trappedWater;
    }
}
