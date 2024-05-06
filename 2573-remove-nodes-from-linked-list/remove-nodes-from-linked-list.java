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

    public ListNode removeNodes(ListNode head) {
        if(head.next == null) return head;

        ListNode curr = head;
        ListNode pre = null;
        
        while(curr != null) {
            ListNode f = curr.next;
            curr.next = pre;
            pre = curr;
            curr = f;
        }
        
        curr = pre.next;
        pre.next = null;

        while (curr != null) {
            ListNode temp = curr.next;
            if (curr.val >= pre.val) {
                curr.next = pre;
                pre = curr;
            }
            curr = temp;
        }

        return pre;
    }
}