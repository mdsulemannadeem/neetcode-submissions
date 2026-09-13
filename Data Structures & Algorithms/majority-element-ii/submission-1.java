
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // Step 1: Find potential candidates using standard loops
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify the candidates using standard loops
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3 && candidate1 != candidate2) {
            result.add(candidate2);
        }

        return result;
    }
}