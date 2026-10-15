
class Node {
    Node[] links = new Node[26]; // Store references to 26 letters
    boolean flag = false; // Check whether a word ends here

    boolean containsKey(char ch) { // Check whether character exists
        return links[ch - 'a'] != null; // Return true if link exists
    }

    void put(char ch, Node node) { // Add a new node
        links[ch - 'a'] = node; // Store node at character index
    }

    Node get(char ch) { // Get the next node
        return links[ch - 'a']; // Return corresponding node
    }

    void setEnd() { // Mark the end of a word
        flag = true; // Word ends here
    }

    boolean isEnd() { // Check whether word ends here
        return flag; // Return end flag
    }
}

class PrefixTree {

    public Node root; // Root node of Trie

    public PrefixTree() {
        root = new Node(); // Initialize root
    }

    public void insert(String word) {
        Node node = root; // Start from root

        for (int i = 0; i < word.length(); i++) { // Iterate through word
            char ch = word.charAt(i); // Get current character

            if (!node.containsKey(ch)) { // If character does not exist
                Node nextNode = new Node(); // Create a new node
                node.put(ch, nextNode); // Connect new node
            }

            node = node.get(ch); // Move to next node
        }

        node.setEnd(); // Mark end of word
    }

    public boolean search(String word) {
        Node node = root; // Start from root

        for (int i = 0; i < word.length(); i++) { // Iterate through word
            char ch = word.charAt(i); // Get current character

            if (!node.containsKey(ch)) { // Character missing
                return false; // Word does not exist
            }

            node = node.get(ch); // Move to next node
        }

        return node.isEnd(); // Check whether complete word exists
    }

    public boolean startsWith(String prefix) {
        Node node = root; // Start from root

        for (int i = 0; i < prefix.length(); i++) { // Iterate through prefix
            char ch = prefix.charAt(i); // Get current character

            if (!node.containsKey(ch)) { // Character missing
                return false; // Prefix does not exist
            }

            node = node.get(ch); // Move to next node
        }

        return true; // Entire prefix exists
    }
}
