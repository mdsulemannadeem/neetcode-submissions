class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        
        // dp[i] is true if s.substring(0, i) can be segmented into words from wordDict
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Empty string is always valid

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If prefix s[0...j-1] is valid and s[j...i-1] is in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check other split points for index i
                }
            }
        }

        return dp[n];
    }
}