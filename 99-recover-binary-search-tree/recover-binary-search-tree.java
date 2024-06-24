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

    private void swap(TreeNode a, TreeNode b) {
        int s  = a.val;
        a.val = b.val;
        b.val = s;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);

        if(pre != null) {
            if(first == null && root.val < pre.val) {
                first = pre;
                middle = root;
            }
            else if(root.val < pre.val) {
                last = root;
                return;
            }
        }
        pre = root;

        inorder(root.right);
    }
    private TreeNode first; TreeNode middle; TreeNode last; TreeNode pre;

    public void recoverTree(TreeNode root) {
        pre = null;
        inorder(root);
        if(last != null) {
            swap(first, last);
            return;
        }
        swap(first, middle);
    }
}