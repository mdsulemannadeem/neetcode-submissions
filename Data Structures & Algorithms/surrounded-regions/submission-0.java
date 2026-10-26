class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Run DFS on the left and right borders
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') dfs(board, r, 0);
            if (board[r][cols - 1] == 'O') dfs(board, r, cols - 1);
        }

        // Step 1: Run DFS on the top and bottom borders
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') dfs(board, 0, c);
            if (board[rows - 1][c] == 'O') dfs(board, rows - 1, c);
        }

        // Steps 2 & 3: Traverse the whole board to flip or restore cells
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X'; // Surrounded region -> capture it
                } else if (board[r][c] == '#') {
                    board[r][c] = 'O'; // Border-connected region -> restore it
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        // Base case: Out of bounds or not part of an 'O' region
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') {
            return;
        }

        // Mark the cell temporarily to indicate it connects to the border
        board[r][c] = '#';

        // Explore all 4 adjacent directions
        dfs(board, r - 1, c); // Up
        dfs(board, r + 1, c); // Down
        dfs(board, r, c - 1); // Left
        dfs(board, r, c + 1); // Right
    }
}
