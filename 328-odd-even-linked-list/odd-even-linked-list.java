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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode Odd = new ListNode(-1);
        ListNode Even = new ListNode(-1);
        ListNode o1 = Odd, e1 = Even;

        int idx = 1;

        while(head != null) {
            ListNode newNode = new ListNode(head.val);
            if(idx % 2 != 0) {
                Odd.next = newNode;
                Odd = newNode;
            }
            else {
                Even.next = newNode;
                Even = newNode;
            }
            head = head.next;
            idx++;
        }
        head = o1.next;
        Odd.next = e1.next;
        return head;
    }
}