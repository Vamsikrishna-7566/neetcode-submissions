class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        backTrack(0,result, nums, temp);

        return result;
    }

    public void backTrack(int index, List<List<Integer>> result, int [] nums, List<Integer> temp){

        if(index >= nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);

        backTrack(index+1, result, nums, temp);
        temp.remove(temp.size()-1);
        backTrack(index+1, result, nums, temp);
    }
}
