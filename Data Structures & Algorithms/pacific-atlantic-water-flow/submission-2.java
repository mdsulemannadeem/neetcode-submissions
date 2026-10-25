class Solution {
    // Direction vectors for moving up, down, left, right
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Perform DFS from the left and right borders
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific, Integer.MIN_VALUE);      // Pacific: left col
            dfs(heights, i, n - 1, atlantic, Integer.MIN_VALUE); // Atlantic: right col
        }

        // Perform DFS from the top and bottom borders
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific, Integer.MIN_VALUE);      // Pacific: top row
            dfs(heights, m - 1, j, atlantic, Integer.MIN_VALUE); // Atlantic: bottom row
        }

        // Collect all cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        // Base cases: check bounds, visited status, and the uphill flow condition
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        // Traverse all 4 directions using the static direction arrays
        for (int i = 0; i < 4; i++) {
            dfs(heights, r + dr[i], c + dc[i], visited, heights[r][c]);
        }
    }
}
