class Solution {

    public int manhattenDistance(int [][] points, int p1, int p2){

      return Math.abs(points[p1][0] - points[p2][0]) + Math.abs(points[p1][1] - points[p2][1]);

    }
    public int minCostConnectPoints(int[][] points) {
        int minDis = 0;
        int n = points.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        queue.add(new int[] {0,0});

        boolean [] visited = new boolean[n];


        while(!queue.isEmpty()){

           int [] current =  queue.poll();
           int weight = current[0];
           int node = current[1];

           if(visited[node]){
                continue;
           }

           visited[node] = true;

           minDis = minDis + weight;

           for(int i=0;i<points.length;i++){

                if(!visited[i]){

                    int dis = manhattenDistance(points, node, i);

                    queue.add(new int[]{dis, i});

                }

           }



        }

        return minDis;
    }
}
