class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean [] freq = new boolean[nums.length];
        backTrack(nums, result, temp, freq);
        return result;
    }

    public void backTrack(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean [] freq){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i] = true;
                temp.add(nums[i]);
                backTrack(nums, result, temp, freq);
                temp.remove(temp.size()-1);
                freq[i] = false;
            }

        }

    }
}
