class Solution {
    public int climbStairs(int n) {
       int [] dp = new int[n+1];
       return exec(n, dp);
    }

    public int exec(int n, int [] dp){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        dp[n] = exec(n-1, dp)+ exec(n-2, dp);

        return dp[n];

    }
}
