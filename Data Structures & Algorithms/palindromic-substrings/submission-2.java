class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        if(s.length()<2){
            return 1;
        }

     

        for(int i=0;i<s.length();i++){

            count++;
            int left = i-1;
            int right = i+1;

            while(left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
                count++;

                left--;
                right++;
            }

            left = i-1;
            right = i;

            while(left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){

                count++;

                left--;
                right++;

            }

        }

        return count;
    }
}
