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
    Integer maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findSum(root);
        return maxSum;
    }

    private int findSum(TreeNode root) {
        if(root == null) return 0;
        int left = findSum(root.left);
        int right = findSum(root.right);

        int currValue = 0;
        if(left <= 0) left = 0;
        if(right <= 0) right = 0;

        maxSum = Math.max(maxSum, (left + right + root.val));
        return Math.max(left, right) + root.val;

    }

}