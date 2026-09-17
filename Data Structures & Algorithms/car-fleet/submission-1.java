public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        
        // Sort cars by position in descending order
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        
        Stack<Double> stack = new Stack<>();
        
        // Standard for loop replacing the enhanced one
        for (int i = 0; i < n; i++) {
            double currentCarTime = (double) (target - pair[i][0]) / pair[i][1];
            stack.push(currentCarTime);
            
            // If the current car takes less or equal time than the car ahead of it,
            // it means it catches up and merges into that fleet.
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        
        return stack.size();
    }
}