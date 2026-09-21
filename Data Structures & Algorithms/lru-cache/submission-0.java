class Node{
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node(){

    }

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node head = new Node();
    Node tail = new Node();

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }



    
    public int get(int key) {
        if (!map.containsKey(key)) {
        return -1;
    }

    int value = map.get(key).val;

    // Move the entry to the front as the most recently used.
    deleteNode(key);
    Node updatedNode = addNode(key, value);
    map.put(key, updatedNode);

    return value;
        
    }

    public Node addNode(int key, int value){
        Node newNode = new Node(key,value);
            Node temp = head.next;
            head.next = newNode;
            newNode.prev = head;
            newNode.next = temp;
            temp.prev = newNode;
            return newNode;
    }

    public void deleteNode(int key){
        Node presentNode = map.get(key);
        Node prevNode = presentNode.prev;
        Node nextNode = presentNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
          deleteNode(key);
          Node updatedNode =  addNode(key,value);
          map.put(key, updatedNode);
        }
        else if(map.size() < capacity){
            

            map.put(key, addNode(key,value));
            
        }else{
            // need to delete the code which is before tail;
            Node tailPrevNode = tail.prev;

            // deleted from both the structures:
            deleteNode(tailPrevNode.key);
            map.remove(tailPrevNode.key);
           

             Node updatedNode =  addNode(key,value);
             map.put(key, updatedNode);

        }
    }
}
