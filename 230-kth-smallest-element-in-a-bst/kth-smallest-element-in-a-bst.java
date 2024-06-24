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

    private void inorder(TreeNode root, int k, int c[]) {
        if(root != null) {
            inorder(root.left, k, c);
            c[0]++;
            if(c[0] == k) {
                value = root.val;
                return;
            }
            inorder(root.right, k, c);
        }
    }
    public int value = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        inorder(root, k, new int[1]);
        return value;
    }
}