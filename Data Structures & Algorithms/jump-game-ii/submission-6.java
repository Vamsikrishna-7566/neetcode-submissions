class Solution {
    public int jump(int[] nums) {

        int farthest = 0;
        int boundary = 0;
        int jump = 0;
    
    for(int i=0;i<nums.length-1;i++){
        farthest = Math.max(farthest, nums[i] + i);

        if(i == boundary){

            jump++;
            boundary = farthest;

        }

    }

    return jump;

  
    }
}
