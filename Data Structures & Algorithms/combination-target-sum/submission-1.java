class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        backTrack(0,  result,  temp,  sum,  target,  nums);
        return result;
    }

    public void backTrack(int index, List<List<Integer>> result, List<Integer> temp, int sum, int target, int[] nums){
    
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        if (index >= nums.length || sum > target) {
        return;
    }
        
            temp.add(nums[index]);
            backTrack(index, result, temp, sum+nums[index],target, nums);
            temp.remove(temp.size()-1);
            backTrack(index+1, result, temp, sum,target, nums);
    

    }
}
