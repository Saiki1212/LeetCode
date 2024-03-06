/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode t1 = head.next;
        ListNode t2 = t1.next;
        while(t2 != null && t2.next != null) {
            if(t1 == t2 ) {
                return true;
            }
            t1 = t1.next;
            t2 = t2.next.next;
        }
        return false;
    }
}