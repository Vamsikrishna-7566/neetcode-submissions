class KthLargest {
    public int k;
    public PriorityQueue<Integer> minHeap;


    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            minHeap.add(nums[i]);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()>k){
            minHeap.poll();
        }
        return minHeap.peek();
    }

   // Constructor Time Complexity: O(N log K)
// add() Time Complexity: O(log K)
// Space Complexity: O(K)
}
