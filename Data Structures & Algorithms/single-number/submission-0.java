class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        boolean flag = false;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]== nums[j] && i!=j){
                    break;
                }

                if(j == nums.length-1){
                    result = nums[i];
                    flag = true;
                }

            }
            if(flag == true){
                return result;
            }
            
        }

        return 0;
    }
}
