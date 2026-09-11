class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
      for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {       // val nahi hai toh rakh lo
                nums[left] = nums[right];
                left++;
            }
            // val hai toh kuch mat karo, bas right aage badho
        }

        return left; 
    }
}