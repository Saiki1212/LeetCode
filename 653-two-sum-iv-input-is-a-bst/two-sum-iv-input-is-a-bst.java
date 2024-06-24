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

    public static boolean inorder(HashSet<Integer> set, TreeNode root, int k) {
        if(root == null) return false;

        if (inorder(set, root.left, k)) {
            return true;
        }

        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);

        return inorder(set, root.right,  k);
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return inorder(set, root, k);
    }

    // Two sum in binary search tree...
}