class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int gasRemaining = 0;
        int startPosition = 0;
        for(int i=0;i<gas.length;i++){
            totalGas = totalGas + gas[i];
            totalCost = totalCost + cost[i];
        }

        if(totalGas < totalCost){
            return -1;
        }

        for(int i=0;i<gas.length;i++){
            gasRemaining = gasRemaining + gas[i] - cost[i];

            if(gasRemaining < 0){

                startPosition = i+1;
                gasRemaining = 0;
            }

        }

        return startPosition;
    }
}
