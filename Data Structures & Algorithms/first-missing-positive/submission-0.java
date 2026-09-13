class Solution {
    public int firstMissingPositive(int[] nums) {
         cyclicSort(nums); // universal template use karo
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1) return i + 1;
    }
    return nums.length + 1;
    }

    public void cyclicSort(int[] arr) {
    int i = 0;
    while (i < arr.length) {
        int correctIdx = arr[i] - 1; 
        if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correctIdx]) {
            int temp = arr[i];
            arr[i] = arr[correctIdx];
            arr[correctIdx] = temp;
            
        } else {
            i++; 
        }
    }
}
}