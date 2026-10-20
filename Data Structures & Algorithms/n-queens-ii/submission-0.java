class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        count = 0; // Reset count for each call
        
        // Tracking arrays for column, main diagonal (\), and anti-diagonal (/)
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n - 1]; // row - col + n - 1
        boolean[] d2 = new boolean[2 * n - 1]; // row + col
        
        // Start recursive backtracking from row 0
        solve(0, n, cols, d1, d2);
        
        return count;
    }

    private void solve(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        // Base Case: All queens are placed successfully, increment the solution counter
        if (row == n) {
            count++;
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            int a = row - col + n - 1; // "\" diagonal identifier
            int b = row + col;         // "/" diagonal identifier

            // PRUNE: If column or diagonals are under attack, skip this choice
            if (cols[col] || d1[a] || d2[b]) {
                continue;
            }

            // Action: Place queen (mark state vectors)
            cols[col] = true;
            d1[a] = true;
            d2[b] = true;

            // Recurse: Try to place queens in the next row
            solve(row + 1, n, cols, d1, d2);

            // Backtrack: Undo state updates for next iterations
            cols[col] = false;
            d1[a] = false;
            d2[b] = false;
        }
    }
}
