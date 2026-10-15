class PrefixTree {

    Set<String> set;

    public PrefixTree() {
         set = new HashSet<>();
    }

    public void insert(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        for(String it: set){
            if(it.startsWith(prefix)){
                return true;
            }
        }

        return false;
    }
}
