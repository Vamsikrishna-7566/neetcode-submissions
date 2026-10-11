class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //Brute force method:
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i] == nums[j] && Math.abs(i-j) <=k){
        //             return true;
        //         }

        //     }

        // }

        // return false;

        // Optimized solution:

        Map<Integer, Integer> map = new HashMap<>();

        int pointer = 0;
        while(pointer < nums.length){
            if(map.containsKey(nums[pointer])){
                if(
                Math.abs(map.get(nums[pointer]) - pointer) <=k
                ){
                    return true;
                }

            }
           
                map.put(nums[pointer], pointer);

            pointer++;
        
        }

        return false;


    }
}