class Solution {
    public int maxProduct(int[] nums) {
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // If curr is negative, max and min swap roles when multiplied
            if (curr < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            maxEndingHere = Math.max(curr, maxEndingHere * curr);
            minEndingHere = Math.min(curr, minEndingHere * curr);
            ans = Math.max(ans, maxEndingHere);
        }

        return ans;
    }
}
