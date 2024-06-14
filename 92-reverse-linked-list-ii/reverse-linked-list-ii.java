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

    // public static void reverseList(ListNode head, ListNode start, ListNode end) {
        
    // }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        int n = 1;
        while(temp != null) {
            if(n >= left && n <= right) {
                list.add(temp.val);
            }
            else if(n > right) break;
            n++;
            temp = temp.next;
        }
        // reverseList(head, start, end);
        temp = head;
        int i=list.size()-1;
        n = 1;
        while(temp != null) {
            if(n >= left && n <= right) {
                temp.val = list.get(i);
                i--;
            }
            else if(n > right) break;
            n++;
            temp = temp.next;
        }
        return head;
    }
}