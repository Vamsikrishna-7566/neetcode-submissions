class Solution {
    public int hammingWeight(int n) {
       
        int count = 0;
        int mod = 0;
        while((n/2 >= 1)){
            mod = n%2;

             if(mod==1){
                count++;
            }

            n = n/2;
           

        }

        if(n/2 == 1){
            count++;
        }

        if(n%2 ==1){

            count++;

        }

        return count;
    }
}
