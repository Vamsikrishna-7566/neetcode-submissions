class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] memo = new int[amount+1];
        for(int i=0;i<memo.length;i++){
            memo[i] = -1;

        }
        int minCoins = calculateMinCoins(amount, coins, memo);

        return minCoins == 1000000 ? -1 : minCoins;
    }


    public int calculateMinCoins(int target, int[] coins, int [] memo){
        if(target == 0){
            return 0;
        }
        if(target < 0){
            return 1000000;
        }

        if(memo[target] != -1){
            return memo[target];
        }
        int minCoins = 1000000;

        for(int i=0;i<coins.length;i++){
            int newTarget = target - coins[i];

            int numberOfCoins = 1 + calculateMinCoins(newTarget, coins, memo);
            minCoins =  Math.min(minCoins, numberOfCoins);

        }

        memo[target] = minCoins;

        return memo[target];


    }
}
