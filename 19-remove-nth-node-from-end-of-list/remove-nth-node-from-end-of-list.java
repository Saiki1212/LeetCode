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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1) return null;

        ListNode temp = head;
        int size = 0;

        // finding the size of the linked list.
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        if(size == n) {
            return head.next;
        }

        int tarIndex = size - n;

        temp = head;
        int idx = 1;

        while(temp != null) {
            if(idx == tarIndex) {
                temp.next = temp.next.next;
                // 3 --> 5
                return head;
            }
            temp = temp.next;
            idx++;
        }
        return head;
    }
}

// size = 5, n = 2;

// tarIdx = 5-2 or 5-2+1;