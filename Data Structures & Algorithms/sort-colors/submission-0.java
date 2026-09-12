class Solution {
    public void sortColors(int[] nums) {
          int low = 0, mid = 0, high = nums.length - 1;
         while (mid <= high) {
        if (nums[mid] == 0) {
            int temp = nums[low];
            nums[low] = nums[mid];
            nums[mid] = temp;
            low++;
            mid++;
        } else if (nums[mid] == 1) {
            mid++; // 1 apni sahi jagah pe hi hai (beech mein)
        } else { // nums[mid] == 2
            int temp = nums[high];
            nums[high] = nums[mid];
            nums[mid] = temp;
            high--; // mid++ mat karo -> naya nums[mid] abhi check nahi hua
        }
         }
    }
}