class Solution {
    public int numDecodings(String s) {
        // An empty string or a string starting with '0' cannot be decoded
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        // prev2 represents dp[i - 2] (ways to decode up to two steps back)
        // prev1 represents dp[i - 1] (ways to decode up to one step back)
        int prev2 = 1;
        int prev1 = 1;

        for (int i = 1; i < s.length(); i++) {
            int current = 0;

            // Check if single-digit decoding is valid ('1' through '9')
            if (s.charAt(i) != '0') {
                current += prev1;
            }

            // Convert the two-character window to an integer without substring overhead
            int twoDigit = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }

            // If current is 0, an invalid sequence (like '30' or '00') was encountered
            if (current == 0) {
                return 0;
            }

            // Shift pointers forward for the next iteration
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
