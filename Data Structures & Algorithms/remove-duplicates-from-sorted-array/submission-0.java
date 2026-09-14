class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 0,fast = 1;
        while(fast < n){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}