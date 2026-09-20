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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 2. Convert each individual node value as a single value for both the linked list.
        // 3. add the numbes.
        // 4. You get a final number.
        // 5. Reverse the final number and store each individual number in a seperate node.
        // 6. return head at the last. 
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        int carry = 0;
        int reminder = 0;
        while(temp1!=null || temp2 !=null || carry != 0){
            int digit1 = (temp1 != null) ? temp1.val : 0;
            int digit2 = (temp2 != null) ? temp2.val : 0;

            
            int sum = digit1+ digit2 + carry;

            carry = sum/10;
            reminder = sum%10;


            ListNode node = new ListNode(reminder);
            start.next = node;
            start = start.next;
            
            if(temp1!= null){
                temp1 = temp1.next;
            }
            if(temp2 != null){
                 temp2 = temp2.next;
            }
           
        }

        return dummy.next;
    }
}
