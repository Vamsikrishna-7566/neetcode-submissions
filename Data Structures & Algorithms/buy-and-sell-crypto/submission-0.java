class Solution {
    public int maxProfit(int[] prices) {
        int maxPrice = 0;
        for(int i=prices.length-1;i>0;i--){
            int profit = 0;
            for(int j=i-1;j>=0;j--){
                profit = prices[i] - prices[j];
                if(profit>maxPrice){
                    maxPrice = profit;
                }
            }
        }
        return maxPrice;
    }
}
