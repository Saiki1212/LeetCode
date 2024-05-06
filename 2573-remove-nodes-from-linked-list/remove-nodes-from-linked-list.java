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
    public static ListNode reverse(ListNode curr) {
        ListNode pre = null;
        while(curr != null) {
            ListNode f = curr.next;
            curr.next = pre;
            pre = curr;
            curr = f;
        }
        return pre;
    }

    public ListNode removeNodes(ListNode head) {
        if(head.next == null) return head;
        ListNode curr = reverse(head);

        ListNode temp = curr.next;
        ListNode pre = curr;

        int value = curr.val;
        

        while(temp != null) {
            if(temp.val < value) {
                pre.next = temp.next;
            }
            else {
                value = temp.val;
                pre = pre.next;
            }
            temp = temp.next;
        }

        head = reverse(curr);

        
        return head;
    }
}