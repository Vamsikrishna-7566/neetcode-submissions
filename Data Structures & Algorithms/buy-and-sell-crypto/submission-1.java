class Solution {
    public int maxProfit(int[] prices) {
       int maxProfit = 0;
       int min = prices[0]; //7
       for(int i=0;i<prices.length;i++){
            int profit = prices[i] - min; 
            //7-7 = 0 
            //1-7 = -6
            // 5-1 = 4
            //3-1 = 2
            //6-1 = 5
            //4-1 = 3
            maxProfit = Math.max(maxProfit, profit);
            //Math.max(0,0); = 0
            //maxProfit = 0
            // 4
            // 4
            //6
            //6
            min = Math.min(min, prices[i]);

            //min = 7
            //1
            //1
            //1
            //1
            //1

       }
       return maxProfit; // 5
    }
}