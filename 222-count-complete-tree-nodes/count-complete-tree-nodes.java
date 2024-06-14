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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int []a = new int[1];
        cou(root,a);
        return a[0];
    }
    public static void cou(TreeNode root, int[]a) {
        if(root != null) {
            a[0]++;
            cou(root.left,a);
            cou(root.right,a);
        }
    }
}