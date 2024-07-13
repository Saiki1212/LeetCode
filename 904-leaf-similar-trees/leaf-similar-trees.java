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

    public void inorder(TreeNode root, List<Integer> leafNodes) {
        if(root == null) return;

        inorder(root.left, leafNodes);
        if(root.left == null && root.right == null) {
            leafNodes.add(root.val);
            return;
        }

        inorder(root.right, leafNodes);

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafNode_root1 = new ArrayList<>();
        List<Integer> leafNode_root2 = new ArrayList<>();

        inorder(root1, leafNode_root1);
        inorder(root2, leafNode_root2);

        return leafNode_root1.equals(leafNode_root2);
    }
}