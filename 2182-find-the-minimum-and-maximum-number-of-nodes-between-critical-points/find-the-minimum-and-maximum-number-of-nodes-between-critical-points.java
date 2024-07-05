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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head.next;
        ListNode pre = head;
        ArrayList<Integer> list = new ArrayList<>();
        int i = 1;

        while(temp.next != null) {
            if((temp.val > pre.val && temp.val > temp.next.val) || (temp.val < pre.val && temp.val < temp.next.val)) {
                list.add(i);
            }
            pre = temp;
            temp = temp.next;
            i++;
        }

        // if(list.isEmpty()) return new int[]{-1, -1};
        if(list.size() <= 1) return new int[]{-1, -1};
        int[] ans = new int[2];

        int mini = Integer.MAX_VALUE;
        for(int j=1; j<list.size(); j++) {
            mini = Math.min(mini, list.get(j) - list.get(j-1));
        }

        ans[0] = mini;
        ans[1] = list.get(list.size()-1) - list.get(0);

        return ans;

    }
}