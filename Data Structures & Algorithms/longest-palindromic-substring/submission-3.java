class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLength = 1;

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check substrings of length 2 to n
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i <= n - len; i++) {

                int j = i + len - 1;

                // First and last characters must match
                if (s.charAt(i) == s.charAt(j)) {

                    // Length 2 or inner substring palindrome
                    if (len == 2 || dp[i + 1][j - 1]) {

                        dp[i][j] = true;

                        // Update longest palindrome
                        if (len > maxLength) {
                            maxLength = len;
                            start = i;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}