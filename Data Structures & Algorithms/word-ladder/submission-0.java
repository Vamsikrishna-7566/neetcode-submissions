class Pair{
    String word;
    int level;
    public Pair(String word, int level){
        this.word = word;
        this.level = level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> stack = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<wordList.size();i++){
            stack.add(wordList.get(i));
        }

        queue.add(new Pair(beginWord, 1));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            String word = pair.word;
            int level = pair.level;
            if(word.equals(endWord) == true){
                return level;
            }

            for(int i=0;i<word.length();i++){
                for(char ch='a'; ch<='z'; ch++){
                    char []charArray = word.toCharArray();
                    charArray[i] = ch;
                    String updatedString = new String(charArray);
                    if(stack.contains(updatedString) == true){
                        stack.remove(updatedString);
                        queue.add(new Pair(updatedString, level+1));

                    }

                }

            }

        }

        return 0;


    }
}