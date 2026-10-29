class Solution {
    public int maxProduct(int[] nums) {

        int prefix = 1;
        int sufix = 1;

        int maxValue = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){

            if(prefix == 0) prefix = 1;
            if(sufix == 0) sufix = 1;

           
            prefix = prefix * nums[i];
            sufix = sufix * nums[nums.length-i-1];

            maxValue = Math.max(maxValue, Math.max(prefix, sufix));

        }

        return maxValue;

        
    }
}
