class Node{
    int val;
    Node prev;
    Node next;
}

class MinStack {
Stack<Integer> minStack;
int minValue;
Node head;
Node tail;

    public MinStack() {
         head = new Node();
         tail = new Node();
        head.next = tail;
        tail.prev = head;

        minStack = new Stack<>();
        minValue = Integer.MAX_VALUE;     
    }
    
    public void push(int val) {
        minStack.push(val);
        if(val > minValue){
            //add to the head
           Node newNode = new Node();
           newNode.val = val;
           Node temp = head.next;

           
           newNode.next = temp;
           newNode.prev = head;
           head.next = newNode;
           temp.prev = newNode;


        }
        else{
            //tail
            Node newNode = new Node();
            Node temp = tail.prev;
            newNode.val = val;

            newNode.next = tail;
            newNode.prev = temp;
            temp.next=newNode;
            tail.prev = newNode;

             minValue = val;
        }
    }
    
    public void pop() {
      int removedVal = minStack.pop();
      if(removedVal > minValue){
        Node temp = head.next;

        head.next = temp.next;
        temp.next.prev = head;
        temp.next = null;
        temp.prev = null;

      }else{
        Node temp = tail.prev;
        tail.prev = temp.prev;
        temp.prev.next = tail;
        temp.next = null;
        temp.prev = null;
        if (minStack.isEmpty()) {
    minValue = Integer.MAX_VALUE;
} else {
    minValue = tail.prev.val;
}

      }

        

    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return minValue;
    }
}
