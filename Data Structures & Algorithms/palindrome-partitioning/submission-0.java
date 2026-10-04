class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int index = 0;
        backTrack(index, temp, result, s);
        return result; 
    }

    public void backTrack(int index, List<String>temp, List<List<String>>result, String s){
        if(index == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(palindrome(index, i, s)){
                temp.add(s.substring(index,i+1));
                backTrack(i+1, temp, result, s);
                temp.remove(temp.size()-1);
            }

        }

    }

    public boolean palindrome(int start, int end, String s){
        while(start<=end){
            if(s.charAt(start)!= s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
