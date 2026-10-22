class Solution {
    // Define the Trie Node structure
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Stores the complete word when a leaf is reached
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        // Step 1: Build the Trie using standard indexed loops
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            TrieNode curr = root;
            for (int j = 0; j < w.length(); j++) {
                int idx = w.charAt(j) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.word = w; // Store full word at the terminal node
        }

        // Step 2: Traverse the board grid using standard indexed loops
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        // Boundary checks and visited check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#') {
            return;
        }

        char ch = board[r][c];
        int idx = ch - 'a';

        // If the character doesn't exist in the Trie path, prune this path
        if (node.children[idx] == null) {
            return;
        }

        node = node.children[idx];

        // If we found a complete word
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // De-duplicate: clear the marker so it isn't added again
        }

        // Mark the current cell as visited
        board[r][c] = '#';

        // Explore all 4 adjacent directions
        dfs(board, r + 1, c, node, result); // Down
        dfs(board, r - 1, c, node, result); // Up
        dfs(board, r, c + 1, node, result); // Right
        dfs(board, r, c - 1, node, result); // Left

        // Backtrack: restore the original character
        board[r][c] = ch;
    }
}
