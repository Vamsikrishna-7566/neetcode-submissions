class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        // Create 2D DP array
        int[][] dp = new int[n][n + 1];

        // Initialize all values to -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return calculate(0, -1, nums, n, dp);
    }

    public int calculate(int presentIndex, int prevIndex,
                         int[] nums, int n, int[][] dp) {

        // Base case
        if (presentIndex == n) {
            return 0;
        }

        // Check if already calculated
        if (dp[presentIndex][prevIndex + 1] != -1) {
            return dp[presentIndex][prevIndex + 1];
        }

        // Option 1: Skip current element
        int len = calculate(presentIndex + 1, prevIndex,
                            nums, n, dp);

        // Option 2: Take current element
        if (prevIndex == -1 ||
            nums[presentIndex] > nums[prevIndex]) {

            len = Math.max(len,
                    1 + calculate(presentIndex + 1,
                                  presentIndex, nums, n, dp));
        }

        // Store result in DP
        dp[presentIndex][prevIndex + 1] = len;

        return len;
    }
}