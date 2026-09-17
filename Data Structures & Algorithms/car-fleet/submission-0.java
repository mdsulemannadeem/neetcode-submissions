class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // 1. Combine position and calculated time into a 2D array
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // 2. Sort cars by their starting position in ascending order
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        int fleets = 0;
        double maxTime = 0;

        // 3. Iterate from right to left (closest to target to farthest)
        for (int i = n - 1; i >= 0; i--) {
            // If the current car takes more time than the fleet ahead of it,
            // it cannot catch up. It starts a new fleet.
            if (cars[i][1] > maxTime) {
                fleets++;
                maxTime = cars[i][1]; // Update the time of the slowest car leading the fleet
            }
            // If it takes less or equal time, it catches up and joins the existing fleet.
        }

        return fleets;
    }
}
