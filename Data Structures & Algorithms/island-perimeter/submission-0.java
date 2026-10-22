class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length;    // rows
        int m = grid[0].length; // cols

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j, n, m);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j, int n, int m) {
        // If out of bounds or water, it contributes 1 to the perimeter
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
            return 1;
        }
        // If already visited (marked as 2 or changed), return 0
        if (grid[i][j] == -1) {
            return 0;
        }

        // Mark current land as visited (e.g., -1 or 2)
        grid[i][j] = -1;

        int perimeter = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            perimeter += dfs(grid, ni, nj, n, m);
        }

        return perimeter;
    }
}
