class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[] >> adjList = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int []temp : times){
            int node = temp[0];
            int connectedNode = temp[1];
            int distance = temp[2];

            adjList.get(node).add(new int []{connectedNode, distance} );
        }


        int [] distance = new int [n+1];
        for(int i=0;i<distance.length ;i++){
            distance[i] = Integer.MAX_VALUE;
        }

        distance[k] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1], b[1])
        );

        queue.offer(new int[] {k,0} );

        while(!queue.isEmpty()){

            int [] current = queue.poll();

            int node = current[0];
            int dist = current[1];


                if(dist > distance[node]){
                continue;
               }

            for(int [] temp: adjList.get(node)){

                int nextNode = temp[0];
                int weight = temp[1];


                int newDistance = dist + weight;

                if(newDistance < distance[nextNode]){

                    distance[nextNode] = newDistance;

                    queue.offer(new int[]{nextNode, newDistance});

                }   

            
            }

        }

        int result = 0;
            for(int i=1;i<distance.length;i++){

                if(distance[i] == Integer.MAX_VALUE){

                    return -1;

                }

               result =  Math.max(result, distance[i]);

            }

        return result;

    }
}
