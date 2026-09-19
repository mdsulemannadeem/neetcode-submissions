class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int windowSum = 0;
     
for(int end = 0; end < nums.length;end++){
      windowSum += nums[end];
 while(windowSum >= target){
    minLen = Math.min(minLen, end - start + 1);
    windowSum -= nums[start];
            start++;
}
        }
       

return minLen == Integer.MAX_VALUE ? 0 :minLen;
        
    }
}