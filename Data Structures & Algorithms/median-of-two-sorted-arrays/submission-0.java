class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int [] groupedNums = new int[n+m];
        for(int i=0;i<n;i++){
            groupedNums[i] = nums1[i];

        }
        int j = nums1.length;

        for(int i = 0; i< m;i++){
            groupedNums[j] = nums2[i];
            j++;
        }

        Arrays.sort(groupedNums);

        int k = groupedNums.length;

        if(k % 2 == 0){
            int m1 = groupedNums[k/2];
            int m2 = groupedNums[(k-1)/2];
            return (double)(m1+m2)/2;
        }else{
            return (double)groupedNums[k/2];
        }
    }
}
