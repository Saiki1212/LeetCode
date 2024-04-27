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
    
    public static int Length(ListNode slow) {

        int n = 0;
        while(slow != null) {
            slow = slow.next;
            n++;
        }
        return n;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode t = head;
        int n = Length(head);
        
        k = n - (k % n);
        if(n == k) return head;

        ListNode slow = head, fast = null;

        while( k-- > 0) {
            fast = slow;
            slow = slow.next;
        }

        fast.next = null;
        head = slow;
        while(slow.next != null) slow = slow.next;
        slow.next = t;
        return head;
    }
}