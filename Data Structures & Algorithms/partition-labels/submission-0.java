class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }

       int left = 0;
       int right = 0;
       int lastOccuranceOfPresentElement = 0;
       int maxOccurance = Integer.MIN_VALUE;
       while(right < s.length()){

        char ch = s.charAt(right);
        lastOccuranceOfPresentElement = map.get(ch);

        if(lastOccuranceOfPresentElement >= maxOccurance){

            maxOccurance = lastOccuranceOfPresentElement;

        }

        if(right == maxOccurance){
            result.add(right-left+1);
            left = right+1;
        }

        right++;

       }

        return result;
    }
}
