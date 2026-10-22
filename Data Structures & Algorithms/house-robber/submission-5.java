class Solution {
    public int rob(int[] nums) {

        // Use memoization ? 
        int [] memo = new int[nums.length];
        int n= nums.length-1;
        return cal(n, nums, memo);
    }

    public int cal(int n, int [] nums, int[] memo){
        
        
        if(n<0){
            return 0;
        }

        if(n == 0){
            return nums[0];
        }
        
        if(memo[n] != 0){
            return memo[n];
        }

        int pick = nums[n] + cal(n-2, nums, memo);
        int notPick = cal(n-1, nums, memo);

        memo[n] =  Math.max(pick, notPick);

        return memo[n];

    }
}
