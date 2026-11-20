class Solution {
    public int maxArea(int[] heights) {
       int start = 0,end = heights.length - 1;
       int max = 0;
        while(start < end){
           int area = Math.min(heights[start], heights[end]) * (end - start);
           max = Math.max(area,max);
           if(heights[start] < heights[end]) start++;
           else end--;
        } 
        return max;
    }
}
