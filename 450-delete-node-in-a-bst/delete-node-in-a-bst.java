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

    public static TreeNode connectNodes(TreeNode root) {
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;

        TreeNode newRootLast = lastNode(root.left);
        newRootLast.right = root.right;
        return root.left;
    }

    public static TreeNode lastNode(TreeNode root) {
        if(root.right == null) return root;
        return lastNode(root.right);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) return connectNodes(root);
        TreeNode target = root;

        while(root != null) {
            if(root.val > key) {
                if(root.left != null && root.left.val == key) {
                    root.left = connectNodes(root.left);
                    break;
                }
                else root = root.left;
            }
            else {
                if(root.right != null && root.right.val == key) {
                    root.right = connectNodes(root.right);
                    break;
                }
                else root = root.right;
            }
        }
        return target;
    }
}