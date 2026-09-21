class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        // Shrink the window until it contains exactly k elements
        while (right - left >= k) {
            // Compare absolute distances to x
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                // The right element is further away (or tied, but we prefer smaller elements)
                right--;
            } else {
                // The left element is further away
                left++;
            }
        }

        // Collect the remaining k elements into the result list
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}
