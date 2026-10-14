class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();
        PriorityQueue <int[]> queue = new PriorityQueue<>((a,b) -> {
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1], b[1]);
        }); 

        for(int i=0;i<arr.length;i++){
            int diff = Math.abs(arr[i] - x);
            queue.offer(new int[]{diff, arr[i]});
        }

        for(int i=0;i<k; i++){
            int [] element = queue.poll();
            result.add(element[1]);
        }

        System.out.println(result);
        Collections.sort(result);

        return result;
    }
}