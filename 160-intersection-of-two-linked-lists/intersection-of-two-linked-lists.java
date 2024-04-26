/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)
            return null;

        int a = 0, b = 0;
        ListNode l1 = headA, l2 = headB;
        while(l1 != null) {
            a++;
            l1 = l1.next;
        }
        while(l2 != null) {
            b++;
            l2 = l2.next;
        }

        l1 = headA; l2 = headB;

        if( a>b ) {
            a = a-b;
            while(a-- > 0) l1 = l1.next;
        }
        else {
            a = b-a;
            while(a-- > 0) l2 = l2.next;
        }


        while(l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }
}