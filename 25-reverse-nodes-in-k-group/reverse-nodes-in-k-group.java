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

    public static void ReverseLL(ListNode curr) {
        ListNode prev = null, forw = null;
        while(curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        // return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;
        
        ListNode mainTemp = head, temp = head;
        ListNode prevTemp = mainTemp;
        int target = 1;
        while(temp != null) {
            if(target < k) {
                temp = temp.next;
                target++;
            }
            else {
                ListNode nextNode = temp.next;
                // System.out.print(prevTemp.val);
                temp.next = null;
                ReverseLL(mainTemp);
                if(head == mainTemp)
                    head = temp;
                else {
                    prevTemp.next = temp;
                    prevTemp = mainTemp;
                }
                mainTemp.next = nextNode;
                mainTemp = nextNode;
                temp = mainTemp;
                target = 1; 
            }
        }
        return head;
    }
}