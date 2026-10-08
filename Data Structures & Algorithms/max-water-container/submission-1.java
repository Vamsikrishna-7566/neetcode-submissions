class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int result = 0;
        while(left < right){

            int height = Math.min(heights[left], heights[right]);
            int area = right - left;
            int totalVolume = height * area;
            result = Math.max(totalVolume, result);
            if(heights[left] > heights[right]){
                right--;

            }
            else{
                left++;
            }
        }

        return result;
    }
}
