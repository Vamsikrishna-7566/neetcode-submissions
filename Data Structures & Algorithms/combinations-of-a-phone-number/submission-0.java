class Solution {
    public List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        int index = 0;
        String[] map = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        }   ;

        backTrack(sb, result, map, index, digits);
        return result;
    }

    public void backTrack(StringBuilder sb, List<String> result, String[] map, int index, String digits){

        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }
        
        char digit = digits.charAt(index);
        int number = digit - '0';

        String letters = map[number];

        for(char ch: letters.toCharArray()){
            sb.append(ch);
            backTrack(sb, result, map, index+1, digits);
            sb.deleteCharAt(sb.length() - 1);

        }

    }

}
