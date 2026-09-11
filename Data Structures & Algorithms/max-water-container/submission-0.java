class Solution {
    public int maxArea(int[] heights) {
        int start = 0; 
        int end = heights.length - 1;
        int maxArea = 0;

        while (start < end) {
            // Calculate the area between the two pointers
            int height = Math.min(heights[start], heights[end]);
            int width = end - start;
            int area = height * width;

            // Update the maximum area
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter bar
            if (heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }
}
