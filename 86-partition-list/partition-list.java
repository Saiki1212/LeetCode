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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode l1 = less;
        ListNode more = new ListNode(-1);
        ListNode m1 = more;
        while(head != null) {
            ListNode newNode = new ListNode(head.val);
            if(head.val < x) {
                l1.next = newNode;
                l1 = newNode;
            }
            else {
                m1.next = newNode;
                m1 = newNode;
            }
            head = head.next;
        }
        l1.next = more.next;
        return less.next;
    }
}