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
        TreeNode newNode = new TreeNode(val);
        if(root == null) return newNode;
        TreeNode temp = root;
        TreeNode temp2 = root;

        while(temp != null) {
            temp2 = temp;
            if(temp.val > val) {
                if(temp.left == null) {
                    temp.left = newNode;
                    return root;
                }
                temp = temp.left;
            }
            else {
                if(temp.right == null) {
                    temp.right = newNode;
                    return root;
                }
                temp = temp.right;
            }
        }
        return root;
    }
}