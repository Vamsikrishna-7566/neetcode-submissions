class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int [] inDegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            for(int it: adjList.get(i)){
                inDegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int [] result = new int[numCourses];
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int i = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            result[i++] = node;
            for(int it: adjList.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0){
                    queue.add(it);
                }
            }
        }
        if(i != numCourses) return new int[]{};
        return result;
    }
}
