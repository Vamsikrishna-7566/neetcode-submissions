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

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode front = null;
        while(head!=null){
            front = head.next;
            head.next = prev;
            prev = head;
            head = front;
        }

        return prev;

    }
    public void reorderList(ListNode head) {

    if (head == null || head.next == null) {
    return;
}
       ListNode dummy = head;
       int count= 0;
       while(dummy!=null){
        count++;
        dummy = dummy.next;
       }

       int halfList = (count + 1) / 2;
       int index = 1;
       ListNode halfPointer = head;
       while(index< halfList){
        halfPointer = halfPointer.next;
        index++;
       }

       ListNode head1 = halfPointer.next;
       halfPointer.next = null;
        ListNode prev = reverseList(head1);

        ListNode first = head;
ListNode second = prev;

while (second != null) {
    // Save both next nodes before changing links.
    ListNode nextFirst = first.next;
    ListNode nextSecond = second.next;

    // Insert a node from the second half after the first.
    first.next = second;
    second.next = nextFirst;

    // Move to the next nodes in both halves.
    first = nextFirst;
    second = nextSecond;

}

       
    }
}
