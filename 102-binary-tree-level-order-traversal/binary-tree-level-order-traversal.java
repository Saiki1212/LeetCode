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
    public List<List<Integer>> levelOrder(TreeNode root) {

        Deque<TreeNode> qq = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        qq.addFirst(root);

        while(!qq.isEmpty()) {
            int len = qq.size();
            ArrayList<Integer> temp = new ArrayList<>();

            while(len-- > 0) {
                TreeNode curr = qq.pollFirst();
                if(curr.left != null) qq.addLast(curr.left);
                if(curr.right != null) qq.addLast(curr.right);
                temp.add(curr.val);
            }
            list.add(new ArrayList<>(temp));
        }
        return list;
    }
}