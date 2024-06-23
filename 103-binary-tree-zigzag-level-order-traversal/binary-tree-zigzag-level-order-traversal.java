/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)return list;

        Deque<TreeNode> dq = new ArrayDeque<>();

        dq.add(root);

        boolean revOrNot = false;
        while(!dq.isEmpty()) {
            int len = dq.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0; i<len; i++) {
                TreeNode curr = dq.pollFirst();
                if(curr.left != null) dq.addLast(curr.left);
                if(curr.right != null) dq.addLast(curr.right);
                temp.add(curr.val);
            }
            if(revOrNot) Collections.reverse(temp);
            list.add(new ArrayList<>(temp));
            revOrNot = !revOrNot;
        }
        return list;
    }
}