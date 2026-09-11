class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores number and its index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Find the number needed to reach the target
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Return indices if complement exists
            }
            map.put(nums[i], i); // Store current number and its index
        }
        return new int[0]; // Return empty array if no solution
    }
}
