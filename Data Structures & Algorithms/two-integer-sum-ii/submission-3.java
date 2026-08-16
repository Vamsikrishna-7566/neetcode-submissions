class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Brute force
       for(int i=0;i<nums.length;i++){
            int newTarget = target - nums[i];
            int j = binarySearch(i+1, nums.length-1, nums, newTarget);
            if(j!=-1){
            return new int[]{i+1, j+1};
            }
        }
        return new int[]{};
      
    }
     public int binarySearch(int left, int right, int [] nums, int target){

        while(left<=right){
            int mid = left + ((right - left)/2);
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
}
