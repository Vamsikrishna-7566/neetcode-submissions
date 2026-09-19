/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = head;
        int count = 0;
        while(dummy!= null){
            count++;
            dummy = dummy.next;
        }

        if(count == n){
            ListNode dummy1 = head;
            head = head.next;
            dummy1.next = null;
            return head;

        }

        int prevNode = count - n;
        int prevCounter = 1;
        ListNode prev = head;
        while(prevCounter < prevNode){
            prevCounter++;
            prev = prev.next;
        }

        ListNode nodeToDelete = prev.next;
        ListNode forwardNode = nodeToDelete.next;

        prev.next = forwardNode;
        nodeToDelete.next = null;

        return head;






    }
}
