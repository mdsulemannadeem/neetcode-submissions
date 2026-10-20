class PrefixTree {

    // Definition of a Trie Node
    private class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            // Stores 26 lowercase English letters ('a' through 'z')
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    /** Initializes the prefix tree object. */
    public PrefixTree() {
        root = new TrieNode();
    }
    
    /** Inserts the string word into the prefix tree. */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    /** Returns true if the string word is in the prefix tree (i.e., was inserted before), and false otherwise. */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }
    
    /** Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
}
