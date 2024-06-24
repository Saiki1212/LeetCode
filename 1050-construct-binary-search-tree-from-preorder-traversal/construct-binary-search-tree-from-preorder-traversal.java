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

    private TreeNode create(int[] pre, int ub) {
        if(pre.length == idx) return null;
        TreeNode root = null;
        if(pre[idx] < ub) {
            root = new TreeNode(pre[idx++]);
        }
        else return null;
        root.left = create(pre, root.val);
        root.right = create(pre, ub);
        return root;
    }
    public int idx = 0;
    public TreeNode bstFromPreorder(int[] pre) {
        return create(pre, 10001);
    }
}