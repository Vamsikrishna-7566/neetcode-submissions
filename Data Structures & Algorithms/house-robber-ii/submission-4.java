class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }
        int [] houses1 = new int[nums.length-1];
        int [] houses2 = new int[nums.length-1];
        for(int i=0;i<nums.length;i++){
            if(i != 0){
                houses1[i-1] = nums[i];
            }

            if(i!=nums.length-1){
                houses2[i] = nums[i];
            }
        }

        int [] memo1 = new int [nums.length];
        for(int i=0;i<memo1.length; i++){
            memo1[i] = -1;
        }



        int sum1 = cal(houses1.length-1, houses1, memo1);

        for(int i=0;i<memo1.length; i++){
            memo1[i] = -1;
        }

        int sum2 = cal(houses2.length-1, houses2, memo1);

        return Math.max(sum1, sum2);



    }

    public int cal(int n, int [] nums, int[] memo){

        if(n==0){
            return nums[0];
        }

        if(n<0){
            return 0;
        }

        if(memo[n] != -1){
            return memo[n];
        }

        int pick = nums[n] + cal(n-2, nums, memo);
        int notPick = cal(n-1, nums, memo);

        memo[n] = Math.max(pick, notPick);

        return memo[n];

    }
}
