class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s == null ? "" : s;
        }
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1;
        
        // Every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // Check substrings of length 2 and greater
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        
                        if (len > maxLength) {
                            start = i;
                            maxLength = len;
                        }
                    }
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }
}
