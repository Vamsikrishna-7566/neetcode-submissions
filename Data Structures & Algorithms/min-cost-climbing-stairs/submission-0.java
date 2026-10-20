class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] min = new int[cost.length+1];
        for(int i=2;i<=cost.length;i++){
            min[i] = Math.min(cost[i-1]+ min[i-1], cost[i-2] + min[i-2]);
        }

        return min[cost.length];
    }
}
