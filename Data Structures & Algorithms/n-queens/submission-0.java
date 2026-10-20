class Solution {
    public List<List<String>> solveNQueens(int n) {
         List<List<String>> result = new ArrayList<>();
        
        // Initialize the chessboard with empty slots ('.')
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Tracking arrays for column, main diagonal (\), and anti-diagonal (/)
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n - 1]; // row - col + n - 1
        boolean[] d2 = new boolean[2 * n - 1]; // row + col
        
        // Start the recursive backtracking process from row 0
        solve(0, n, cols, d1, d2, board, result);
        return result;
    }

  private void solve(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2,
 char[][] board, List<List<String>> result){
 if(row == n){ // saari rows mein queen
 List<String> snap = new ArrayList<>();
 for(int i = 0; i < n; i++) snap.add(new String(board[i])); // snapshot
 result.add(snap);
 return;
 }
 for(int col = 0; col < n; col++){
 int a = row - col + n - 1; // "\" diagonal id
 int b = row + col; // "/" diagonal id
 if(cols[col] || d1[a] || d2[b]) continue; // PRUNE: attack hoga
 board[row][col] = 'Q';
 cols[col] = true; d1[a] = true; d2[b] = true; // place
 solve(row + 1, n, cols, d1, d2, board, result);
 board[row][col] = '.';
 cols[col] = false; d1[a] = false; d2[b] = false; // undo
 }
}

}
