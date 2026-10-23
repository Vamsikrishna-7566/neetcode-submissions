class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String result ="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String temp = s.substring(i,j+1);
                if(palindrome(temp)){
                    if(j-i+1 > maxLength){
                        maxLength = j-i+1;
                        result = s.substring(i,j+1);

                    }
                }

            }

        }

        return result;

    }

    public boolean palindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;

        }

        return true;

    }
}