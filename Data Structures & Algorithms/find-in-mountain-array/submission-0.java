/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int n = mountainArr.length();

        // Find peak
        int peak = findPeak(mountainArr, n);

        // Search increasing part first
        int ans = binarySearchIncreasing(
            mountainArr, target, 0, peak
        );

        if (ans != -1) {
            return ans;
        }

        // Search decreasing part
        return binarySearchDecreasing(
            mountainArr, target, peak + 1, n - 1
        );
    }

    private int findPeak(MountainArray arr, int n) {

        int low = 0;
        int high = n - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr.get(mid) < arr.get(mid + 1)) {
                // Increasing side
                low = mid + 1;
            } else {
                // Decreasing side
                high = mid;
            }
        }

        return low;
    }

    private int binarySearchIncreasing(
        MountainArray arr,
        int target,
        int low,
        int high
    ) {

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int value = arr.get(mid);

            if (value == target) {
                return mid;
            }

            if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int binarySearchDecreasing(
        MountainArray arr,
        int target,
        int low,
        int high
    ) {

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int value = arr.get(mid);

            if (value == target) {
                return mid;
            }

            if (value < target) {
                // Need to go left
                high = mid - 1;
            } else {
                // Need to go right
                low = mid + 1;
            }
        }

        return -1;
    }
}