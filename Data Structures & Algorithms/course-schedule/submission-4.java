class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         List<List<Integer>> preReq = new ArrayList<>();
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            preReq.add(new ArrayList<>());
        }

        //Converting into adjcency list.
        for(int i=0;i<prerequisites.length;i++){
            preReq.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int [] inDegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it: preReq.get(i)){
                inDegree[it]++;
            }
        }

        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;

            for(int it: preReq.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    queue.add(it);
                }
            }
        }

        System.out.println(count);

        if(count != numCourses) return false;
        return true;
    }
}
