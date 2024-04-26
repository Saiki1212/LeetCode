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

    public static boolean isRevAndPal(ListNode head, ListNode curr) {
        ListNode pre = null;
        ListNode forr = null;
        while(curr != null) {
            forr = curr.next;
            curr.next = pre;
            pre = curr;
            curr = forr;
        }
        curr = pre;
        while(curr != null) {
            if (head.val != curr.val) return false;
            head = head.next;
            curr = curr.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return isRevAndPal(head, slow);

    }
}