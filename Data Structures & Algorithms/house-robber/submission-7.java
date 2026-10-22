class Solution {
    public int rob(int[] nums) {

        // Use memoization ? 
        int [] memo = new int[nums.length];

        for(int i=0;i<memo.length;i++){
            memo[i] = -1;

        }
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

        if(memo[n] != -1){
            return memo[n];
        }

        int pick = nums[n] + cal(n-2, nums, memo);
        int notPick = cal(n-1, nums, memo);

        memo[n] =  Math.max(pick, notPick);

        return memo[n];

    }
}
