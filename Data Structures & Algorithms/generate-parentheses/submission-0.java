class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, n, "", 0, 0);
        return result;
    }

    public void backTrack(List<String> result, int n, String currentString, int open, int close){
        if(currentString.length() == n *2){
            result.add(currentString);
            return;
        }

       if(open < n) backTrack(result, n, currentString + "(", open+1, close);

       if(close < open) backTrack(result, n, currentString + ")", open, close+1);

    }
}
