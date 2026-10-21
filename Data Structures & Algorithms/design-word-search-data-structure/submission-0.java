class WordDictionary {
    
    // Define the TrieNode structure
    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26]; // For lowercase English letters 'a' through 'z'
            isEnd = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Inserts a word into the trie
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    // Returns true if the word is in the data structure (handles '.' wildcard)
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    // Your helper function for backtracking search
    private boolean dfs(String w, int pos, TrieNode node) {
        if (pos == w.length()) return node.isEnd;

        char ch = w.charAt(pos);
        if (ch != '.') {
            TrieNode next = node.children[ch - 'a'];
            return next != null && dfs(w, pos + 1, next);
        }

        // If it's '.', match any available character
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null && dfs(w, pos + 1, node.children[i])) {
                return true;
            }
        }
        return false;
    }
}
