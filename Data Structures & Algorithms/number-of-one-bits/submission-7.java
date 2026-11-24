class Solution {
    public int hammingWeight(int n) {
       
        int count = 0;
        int mod = 0;

        //First I have written it as n/2 !=0. 
        //Next realised it is n/2 >= 1
        // The while loop is for the numbers which are greater than 1.
        // 1 and 0 condition are hanled below.


        while((n/2 >= 1)){
            mod = n%2;

             if(mod==1){
                count++;
            }

            n = n/2;
           

        }

        //The below conditions are for the last LCM where we consider remindor as well as divisor.

        if(n/2 == 1){
            count++;
        }

        if(n%2 ==1){

            count++;

        }

        return count;
    }
}
