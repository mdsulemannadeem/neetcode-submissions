class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Step 2: Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1; // Step 3: Two pointers (start and end)
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) { // Step 4: If sum is zero, add the triplet
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    // Step 5: Skip duplicates for the second and third numbers
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }

                    start++; // Move pointers after adding the triplet
                    end--;
                } else if (sum < 0) {
                    start++; // Increase the sum
                } else {
                    end--; // Decrease the sum
                }
            }
        }

        return result;
    }
}