class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int [] nums = new int [26];

        for(int i=0;i<tasks.length;i++){
            nums[tasks[i] - 'A']++;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                maxHeap.add(nums[i]);
            }
        }

        int time = 0;

        while(!maxHeap.isEmpty()){
            int cycle = n + 1;
            List<Integer> temp = new ArrayList<>();


            while(cycle>0 && !maxHeap.isEmpty()){
            int count = maxHeap.poll();
            count--;

            if(count>0) temp.add(count);

            time++;
            cycle--;
            
         }

         for(int i: temp){
            maxHeap.add(i);
         }

         if(!maxHeap.isEmpty()){
            time = time + cycle;

         }

        }

        return time;

    }
}
