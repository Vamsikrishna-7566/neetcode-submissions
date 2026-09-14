class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //1 Find the maximum value in the array.
        int maxValue = Integer.MIN_VALUE;
        int result = 0;
        for(int i=0;i<piles.length;i++){
            maxValue = Math.max(maxValue, piles[i]);
        }
        if(piles.length == h){
            return maxValue;
        }

        int low = 1;
        int high = maxValue;
        while(low <= high){
            int mid = low + ((high - low)/2);
            int hoursCount = bananaToEat(piles, mid);
            if(hoursCount <= h){
                result = mid;
                high = mid - 1;

            }
            else{
                low = mid + 1;
            }

        }

        return result;
    }

    public int bananaToEat(int[] piles, int mid){
        int totalHours = 0;
        for(int i=0;i<piles.length;i++){
            totalHours += Math.ceil((double)piles[i] /(double) mid);
        }
        return totalHours;
    }
}