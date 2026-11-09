class Solution {
    public int[][] merge(int[][] intervals) {

        List<int []> result  = new ArrayList<>();
        // 1. Sort the intervals: O(logn)
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int i=0;

        while(i<intervals.length){
            int [] current = intervals[i];
            int j = i+1;

            

           while(j<intervals.length){

                int [] next = intervals[j];
                if(current[1] >= next[0]){
                    int maxVal = Math.max(current[1], next[1]);
                    current[1] = maxVal;
                    j++;
                }
                else{
                    break;
                }

            }
            result.add(current);
            i=j;

        }

        return result.toArray(new int[result.size()][]);
    }
}
