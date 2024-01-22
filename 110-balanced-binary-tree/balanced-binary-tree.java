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
    public static int findHeight(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(findHeight(root.left),  findHeight(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(findHeight(root.left)-findHeight(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}