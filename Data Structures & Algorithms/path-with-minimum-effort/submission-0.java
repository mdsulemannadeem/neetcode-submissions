class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        // dist[r][c] stores the maximum absolute difference in heights 
        // needed to reach cell (r, c)
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        
        // Min-heap stores arrays of {effort, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0});
        
        // Directions grid for navigating: right, left, down, up
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentEffort = current[0];
            int r = current[1];
            int c = current[2];
            
            // If we reached the bottom-right, return the effort
            if (r == m - 1 && c == n - 1) {
                return currentEffort;
            }
            
            // If the path we found to this cell is worse than the already recorded one, skip
            if (currentEffort > dist[r][c]) {
                continue;
            }
            
            // Traditional index-based loop for traversing neighbors
            for (int i = 0; i < directions.length; i++) {
                int nr = r + directions[i][0];
                int nc = c + directions[i][1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    // Calculate the effort to reach this neighbor
                    int newEffort = Math.max(currentEffort, Math.abs(heights[r][c] - heights[nr][nc]));
                    
                    // If we found a path with a smaller effort to this neighbor, update and add to heap
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.offer(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }
        
        return 0; // Fallback
    }
}
