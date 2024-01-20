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
    public static int count = 0;
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        cou(root);
        System.gc();
        int ans = count;
        count = 0;
        return ans;
    }
    public static void cou(TreeNode root) {
        if(root != null) {
            count++;
            cou(root.left);
            cou(root.right);
        }
    }
}