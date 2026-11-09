public class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        // PriorityQueue stores: {max_toll_so_far, row, col}
        // Generic type <int[]> explicitly defined for clean execution
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];

        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        // Separated directional arrays for row and col transitions
        int[] dRow = {0, 0, 1, -1};
        int[] dCol = {1, -1, 0, 0};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int toll = curr[0];
            int r = curr[1];
            int c = curr[2];

            // If we reach the bottom-right corner, return the answer
            if (r == n - 1 && c == n - 1) {
                return toll;
            }

            // Using simple for loop instead of enhanced for loop
            for (int i = 0; i < 4; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];
                
                // Boundary and visited validation checks
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    
                    // The cost to move to the next cell is the max path height encountered so far
                    int nextToll = Math.max(toll, grid[nr][nc]);
                    pq.offer(new int[]{nextToll, nr, nc});
                }
            }
        }
        return -1;
    }
}
