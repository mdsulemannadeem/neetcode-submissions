class Solution {
    public boolean search(int[] nums, int target) {
   
           int start = 0;
        int end = nums.length - 1;
  
        while (start <= end){
            int mid= start + (end - start) /2;
            if(nums[mid] == target){
                return true;
            } 
            if(nums[start] == nums[mid] && nums[end] == nums[mid]){
                start++;
                end--;
            }
             // Check if the left half is sorted
          else if (nums[start] <= nums[mid]) {
                // Check if the target lies within this sorted left half
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                // Check if the target lies within this sorted right half
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
