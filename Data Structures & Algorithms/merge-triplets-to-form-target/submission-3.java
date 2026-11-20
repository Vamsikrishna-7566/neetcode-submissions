class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int [] result = new int[3];

        for(int i=0;i<triplets.length;i++){

            if(triplets[i][0] > target[0] || 
            triplets[i][1] > target[1] ||
            triplets[i][2] > target[2]){

                continue;

            }

            
            int j=0;
            while(j<3){
                
                result[j] = Math.max(triplets[i][j], result[j]);
                j++;
            }
           
        }

        for(int i=0;i<target.length;i++){
            if(target[i] != result[i]){
                return false;
            }

        }

        return true;
        // int n = target.length;
        // int m = target.length;
        
        // for(int i=0;i<triplets.length-1;i++){
            
        //     int [] temp = new int[3];

        //     for(int j=i+1;j<triplets.length;j++){

        //         int counter = 0;
        //         while(counter<3){
        //         temp[counter] = Math.max(triplets[i][counter], triplets[j][counter]);
        //         counter++;
        //      }

        //      for(int k=0;k<3;k++){
        //         if(temp[k]!=target[k]){
        //             break;
        //         }

        //         if(k==2){
        //             return true;
        //         }
        //     }

        // }

        // }

        // return false;
    }
}
