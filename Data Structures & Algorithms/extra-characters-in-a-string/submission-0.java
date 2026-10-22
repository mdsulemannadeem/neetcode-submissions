class Solution {
    // Define the Trie Node structure
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
    
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        TrieNode root = new TrieNode();
        
        // Step 1: Build the Trie using standard indexed loops
        for (int i = 0; i < dictionary.length; i++) {
            String word = dictionary[i];
            TrieNode curr = root;
            
            for (int j = 0; j < word.length(); j++) {
                int idx = word.charAt(j) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx]; // move to next node
            }
            curr.isWord = true;
        }
        
        // Step 2: DP Array (dp[i] represents min extra chars for suffix s[i...n-1])
        int[] dp = new int[n + 1];
        
        // Step 3: Fill DP table from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Base choice: treat s.charAt(i) as an extra character
            dp[i] = dp[i + 1] + 1;
            
            // Traverse the Trie using characters starting from index i
            TrieNode curr = root;
            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                
                // If there's no matching prefix in our dictionary, break early
                if (curr.children[idx] == null) {
                    break;
                }
                
                curr = curr.children[idx];
                
                // If a valid word ends at index j, consider it a match
                if (curr.isWord) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }
        
        return dp[0];
    }
}
