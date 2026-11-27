public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        // Fill the first row (can only come from the left)
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // Fill the first column (can only come from above)
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        // The bottom-right cell now holds the minimum path sum
        return grid[m - 1][n - 1];
    }
}