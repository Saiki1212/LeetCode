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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }
        TreeNode curr = root;
        while(true) {
            int data = curr.val;
            if(data > val && curr.left == null) {
                TreeNode newNode = new TreeNode(val);
                curr.left = newNode;
                return root;
            }
            else if(data < val && curr.right == null) {
                TreeNode newNode = new TreeNode(val);
                curr.right = newNode;
                return root;
            }

            if(data > val) curr = curr.left;
            else curr = curr.right;
        }
    }
}