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

    private void addValues(TreeNode root) {
        if(root == null) return;
        addValues(root.right);
        root.val += max;
        max = root.val;
        addValues(root.left);
    }

    public int max = 0;

    public TreeNode bstToGst(TreeNode root) {
        addValues(root);
        return root;
    }
}