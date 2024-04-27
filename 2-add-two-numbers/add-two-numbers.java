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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2;
        ListNode temp = new ListNode(1);
        ListNode head = temp;

        int carry = 0;

        while(t1 != null && t2 != null) {
            ListNode newNode = new ListNode();
            int val = t1.val + t2.val + carry;
            if(val < 10) {
                newNode.val = val;
                temp.next = newNode;
                temp = temp.next;
                carry = 0;
            }
            else {
                newNode.val = val-10;
                temp.next = newNode;
                temp = temp.next;
                carry = 1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }

        while(t1 != null) {
            int val = t1.val + carry;
            ListNode newNode = new ListNode();
            if(val < 10) {
                newNode.val = val;
                temp.next = newNode;
                temp = temp.next;
                carry = 0;
            }
            else {
                newNode.val = val-10;
                temp.next = newNode;
                temp = temp.next;
                carry = 1;
            }
            t1 = t1.next;
        }

        while(t2 != null) {
            ListNode newNode = new ListNode();
            int val = t2.val + carry;
            if(val < 10) {
                newNode.val = val;
                temp.next = newNode;
                temp = temp.next;
                carry = 0;
            }
            else {
                newNode.val = val-10;
                temp.next = newNode;
                temp = temp.next;
                carry = 1;
            }
            t2 = t2.next;
        }
        if(carry == 1) {
            ListNode newNode = new ListNode(1);
            temp.next = newNode;
        }
        return head.next;
    }
}