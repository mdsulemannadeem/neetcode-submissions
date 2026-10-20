class Solution {
    // Unique sets to track threats down columns, main diagonals, and anti-diagonals
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diag = new HashSet<>();     // Main diagonal (\) mapped via (row - col)
    private Set<Integer> antiDiag = new HashSet<>(); // Anti-diagonal (/) mapped via (row + col)

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        solve(0, board, res, n);
        return res;
    }

    private void solve(int row, char[][] board, List<List<String>> res, int n) {
        // Base Case: All rows successfully filled
        if (row == n) {
            res.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            // Check safety using O(1) HashSet lookups
            if (cols.contains(col) || diag.contains(row - col) || antiDiag.contains(row + col)) {
                continue; // PRUNE: Under attack
            }

            // Action: Place Queen & add coordinates to tracking sets
            board[row][col] = 'Q';
            cols.add(col);
            diag.add(row - col);
            antiDiag.add(row + col);

            // Recurse: Go to the next row
            solve(row + 1, board, res, n);

            // Backtrack: Remove Queen & remove coordinates from tracking sets
            board[row][col] = '.';
            cols.remove(col);
            diag.remove(row - col);
            antiDiag.remove(row + col);
        }
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}
