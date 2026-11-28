class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        // Lengths must add up
        if (m + n != s3.length()) {
            return false;
        }

        boolean[] dp = new boolean[n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    boolean takeFromS1 = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    boolean takeFromS2 = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    dp[j] = takeFromS1 || takeFromS2;
                }
            }
        }

        return dp[n];
    }
}
