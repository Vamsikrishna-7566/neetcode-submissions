class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            maxHeap.add(stones[i]);
        }

        int i=0;
        while(maxHeap.size()>1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int hit = Math.abs(stone1 - stone2);
            if(hit == 0){
                continue;
            }else{
                maxHeap.add(hit);
            }

        }

        if(maxHeap.size()==0) return 0;
        return maxHeap.peek();
    }
}
