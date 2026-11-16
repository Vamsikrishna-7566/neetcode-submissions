class Solution {
    public int jump(int[] nums) {
    
    if(nums.length == 1){
        return 0;

    }
    
    int i=0;
    int jump = 0;
    

    while(i<nums.length){

        if(nums[i] + i >= nums.length-1){
            return jump+1;
        }

        int boundary = nums[i] + i;
        int j = i+1;
        int wantedJ = i;
        int maxJump = 0;
        while(j<=boundary){

            if(nums[j] + j > maxJump){

                maxJump = nums[j] + j;
                wantedJ = j;
            }
            j++;

        }

        jump++;
        i = wantedJ;

    }

    return jump;

  
    }
}
