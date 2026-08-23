class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int [] hashA = new int[26];
        int [] hashB = new int[26];
        for(int i=0;i<s1.length();i++){
            hashA[s1.charAt(i)-'a']++;
            hashB[s2.charAt(i)-'a']++;
        }
        int left = 0;
        int right = s1.length()-1;
        while(right<s2.length()){
            if(Arrays.equals(hashA, hashB)){
                return true;
            }
            hashB[s2.charAt(left) - 'a']--;
            left++;
            right++;
            if(right<s2.length()){
                
                hashB[s2.charAt(right)-'a']++;
            }
        }
        return false;
    }
}
