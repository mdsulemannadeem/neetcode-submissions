class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Use a Queue of int arrays to store the coordinates {row, col}
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Initialize queue with all rotten oranges and count fresh ones
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Step 2: Perform Multi-Source BFS
        while (!q.isEmpty() && freshCount > 0) {
            minutes++;
            int size = q.size();
            while (size-- > 0) {
                int[] current = q.poll();
                int r = current[0];
                int c = current[1];

                for (int k = 0; k < 4; ++k) {
                    int nr = r + dx[k];
                    int nc = c + dy[k];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCount--;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}
