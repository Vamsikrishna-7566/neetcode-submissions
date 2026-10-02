class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>>result = new ArrayList<>();
        backTrack(0, temp, result, nums);
        return result;
    }

    public void backTrack(int index, List<Integer> temp, List<List<Integer>>result, int[] nums){

        if(result.contains(temp)) return;
        if(index>=nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        backTrack(index+1, temp, result, nums);
        temp.remove(temp.size()-1);
        backTrack(index+1, temp, result, nums);

    }
}
