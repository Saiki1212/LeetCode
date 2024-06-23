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

    public static void inorder(TreeNode root, ArrayList<TreeNode> list) {
        if(root == null) {
            return;
        }
        list.add(root);
        inorder(root.left, list);
        inorder(root.right, list);
    }

    public void flatten(TreeNode root) {
        if(root == null) return;
        ArrayList<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        root = list.remove(0);
        root.left = null;
        while(!list.isEmpty()) {
            root.right = list.remove(0);
            root.left = null;
            root = root.right;
        }
    }
}