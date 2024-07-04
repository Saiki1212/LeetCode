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
    public ListNode mergeNodes(ListNode head) {
        ListNode xxxx = new ListNode(0), temp = head;
        ListNode pre = xxxx;

        while(temp != null) {
            if(temp.val == 0) {
                int sum = 0;
                temp = temp.next;
                while(temp.val != 0) {
                    sum += temp.val;
                    temp = temp.next;
                }
                ListNode preSum = new ListNode(sum);
                // pre.val = sum;
                pre.next = preSum;
                pre = preSum;
            }
            if(temp.next == null) break;
        }
        return xxxx.next;
    }
}