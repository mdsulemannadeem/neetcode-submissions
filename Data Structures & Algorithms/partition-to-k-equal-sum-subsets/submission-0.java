class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

       if (sum % k != 0) {
            return false;
        }
        int targetSubsetSum = sum / k;
         Arrays.sort(nums);

         if (nums[nums.length - 1] > targetSubsetSum) {
            return false;
        }
int[] buckets = new int[k];

       
        return solve(nums, nums.length - 1, buckets, targetSubsetSum);
    }

    private boolean solve(int[] nums, int index, int[] buckets, int target) {
         if (index < 0) {
            return true;
        }

        int currentNum = nums[index];
     for (int i = 0; i < buckets.length; i++) {
            
          
            if (buckets[i] + currentNum > target) {
                continue;
            }

             boolean duplicate = false;
            for (int j = 0; j < i; j++) {
                if (buckets[i] == buckets[j]) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                continue;
            }
             buckets[i] += currentNum;
            if (solve(nums, index - 1, buckets, target)) {
                return true;
            }
             buckets[i] -= currentNum;
        }

        return false;
    }
}
