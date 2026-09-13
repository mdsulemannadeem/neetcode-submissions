class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map =
                new HashMap<>();

        // Important step
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        // Simple for loop
        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];
int need = prefixSum - k;
            if (map.containsKey(need)) {

                count += map.get(need);

            }
             map.put(prefixSum,
                    map.getOrDefault(prefixSum, 0) + 1);
        }
             return count;
    }
}