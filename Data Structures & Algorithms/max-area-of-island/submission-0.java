class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int n = grid.length;    // number of rows
        int m = grid[0].length; // number of columns
        int maxArea = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // Start DFS to calculate the area of the current island
                    int currentArea = dfs(grid, i, j, n, m);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int[][] grid, int i, int j, int n, int m) {
        // Base case: if out of bounds or water (0), the area contributed is 0
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
            return 0;
        }
        
        // Mark the current cell as visited by sinking it to 0
        grid[i][j] = 0; 
        
        // Count this current cell as 1 unit of area
        int area = 1;
        
        // Explore all 4 orthogonal directions
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            area += dfs(grid, ni, nj, n, m);
        }
        
        return area;
    }
}
