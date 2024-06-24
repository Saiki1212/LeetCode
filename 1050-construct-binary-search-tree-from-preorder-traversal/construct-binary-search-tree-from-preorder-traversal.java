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
    public TreeNode bstFromPreorder(int[] pre) {
        int n = pre.length;
        TreeNode root = new TreeNode(pre[0]);

        for(int i=1; i<n; i++) {
            TreeNode node = root;
            int v = pre[i];

            while(node != null) {
                if(node.val > v) {
                    if(node.left == null) {
                        TreeNode newNode = new TreeNode(v);
                        node.left = newNode;
                        break;
                    }
                    node = node.left;
                }
                else {
                    if(node.right == null) {
                        TreeNode newNode = new TreeNode(v);
                        node.right = newNode;
                        break;
                    }
                    node = node.right;
                }
            }
        }
        return root;
    }
}