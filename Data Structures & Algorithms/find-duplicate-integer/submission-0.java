class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(int i: map.keySet()){
            int value = map.get(i);
            if(value >1){
                return i;
            }

        }

        return -1;
    }
}
