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
    private int find(TreeNode root) {
        if(root == null) return 0;

        int leftH = find(root.left);
        int rightH = find(root.right);

        sum = Math.max(sum, leftH + rightH);
        return Math.max(leftH, rightH) +1;
    }

    Integer sum = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        find(root);
        return sum;
    }
}