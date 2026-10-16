class Node{
    Node[] links = new Node[26];
    boolean flag = false;
}

class WordDictionary {
   Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {

        Node node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.links[ch - 'a'] == null){
                node.links[ch - 'a'] = new Node();
            }
            node = node.links[ch-'a'];
        }

        node.flag = true;   
    }

    

    public boolean search(String word) {
        Node node = root;
       return DFS(word, 0, node);
    }

    public boolean DFS(String word, int index, Node node){

        if(index == word.length()){
            return node.flag;
        }
        char ch = word.charAt(index);
        if(ch == '.'){
           for(int i=0;i<node.links.length ;i++){
                if(node.links[i] != null){
                    Node presentNode = node.links[i];
                    if(DFS(word, index+1, presentNode)){
                        return true;
                    }
                }

           }

           return false;

        }

        if(node.links[ch - 'a'] == null){
            return false;
        }
        node = node.links[ch - 'a'];
        return DFS(word, index+1, node);
    }
}
