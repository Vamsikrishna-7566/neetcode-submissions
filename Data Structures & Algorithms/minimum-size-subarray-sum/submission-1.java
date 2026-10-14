class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int minResult = Integer.MAX_VALUE;
        while(right<nums.length){
            sum = sum + nums[right];
            while(sum >= target){
                minResult = Math.min(right-left+1, minResult);
                sum = sum - nums[left];
                left++;
            }
            
            right++;
        }

        if(minResult == Integer.MAX_VALUE){
            return 0;

        }

        return minResult;
    }
}