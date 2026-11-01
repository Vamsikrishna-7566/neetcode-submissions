

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        // Convert dictionary to a set
        Set<String> wordSet = new HashSet<>(wordDict);

        // Find maximum word length
        int maxLen = 0;

        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        int n = s.length();

        // dp[i] tells whether first i characters can be split
        boolean[] dp = new boolean[n + 1];

        // Empty string is valid
        dp[0] = true;

        // Check every prefix
        for (int i = 1; i <= n; i++) {

            // Try possible starting positions of the last word
            for (int j = i - 1;
                 j >= Math.max(0, i - maxLen);
                 j--) {

                // Previous prefix must be valid
                // Current substring must be in dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {

                    dp[i] = true;
                    break;
                }
            }
        }

        // Can the entire string be segmented?
        return dp[n];
    }
}