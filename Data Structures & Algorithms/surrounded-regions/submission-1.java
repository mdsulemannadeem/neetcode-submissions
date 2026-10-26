class Solution {
    // Helper for DFS traversal
    private void dfs(char[][] board, int n, int m, int i, int j) {
        // Mark as safe using '#' instead of 'O'
        board[i][j] = '#';
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            // Check boundaries and if it's an 'O'
            if (ni >= 0 && ni < n && nj >= 0 && nj < m && board[ni][nj] == 'O') {
                dfs(board, n, m, ni, nj);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0)
            return;
        int m = board[0].length;

        // Traverse boundaries and start DFS for 'O'
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                dfs(board, n, m, i, 0);
            if (board[i][m - 1] == 'O')
                dfs(board, n, m, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O')
                dfs(board, n, m, 0, j);
            if (board[n - 1][j] == 'O')
                dfs(board, n, m, n - 1, j);
        }

        // Final pass to convert '#' back to 'O' and 'O' to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}