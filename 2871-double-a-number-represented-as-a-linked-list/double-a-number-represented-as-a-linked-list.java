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
    public ListNode doubleIt(ListNode head1) {
        if(head1 == null) return head1;
        ListNode head2 = new ListNode(0);
        head2.next = head1;

        ListNode pre = head2;
        ListNode curr = head1;

        while(curr != null) {
            int val = curr.val * 2;
            if(val >= 10) pre.val++;
            curr.val = val % 10;
            curr = curr.next;
            pre = pre.next;
        }
        return head2.val == 1 ? head2 : head1;
    }
}