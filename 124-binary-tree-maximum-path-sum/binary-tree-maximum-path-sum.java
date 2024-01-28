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
    public int maxi = Integer.MIN_VALUE;
    private int find(TreeNode root) {
        if(root == null) return 0;
        int l = Math.max(0, find(root.left));
        int r = Math.max(0, find(root.right));
        maxi = Math.max(maxi, (l+r+root.val));
        return root.val+Math.max(l, r);
    }
    public int maxPathSum(TreeNode root) {
        find(root);
        return maxi;
    }
}