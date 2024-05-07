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
    public ListNode doubleIt(ListNode head) {
        if(head == null) return head;
        ListNode pre = null;

        while(head != null) {
            ListNode f = head.next;
            head.next = pre;
            pre = head;
            head = f;
        }
        head = pre.next;
        pre.next = null;
        int carry = (pre.val >= 5) ? 1 : 0;

        pre.val = (pre.val >= 5) ? (pre.val * 2) % 10 : pre.val * 2;

        while (head != null) {
            ListNode nextNode = head.next;
            int value = head.val * 2 + carry;
            carry = value > 9 ? 1 : 0;
            head.val = (value > 9) ? value % 10 : value;
            head.next = pre;
            pre = head;
            head = nextNode;
        }
        if(carry == 1) {
            ListNode newNode = new ListNode(1, pre);
            return newNode;
        }
        return pre;
    }
}