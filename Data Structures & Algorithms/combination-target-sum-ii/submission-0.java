class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(0, target, result, temp, candidates);
        return result;
    }

    public void backTrack(int index, int target, List<List<Integer>> result, List<Integer> temp, int[] candidates){
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i] > target) break;
            temp.add(candidates[i]);
            backTrack(i+1, target - candidates[i], result, temp, candidates);
            temp.remove(temp.size()-1);

        }

    }
}
