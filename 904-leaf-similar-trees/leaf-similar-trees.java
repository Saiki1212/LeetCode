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

    public static void Inorder(TreeNode root, List<Integer> list) {
        if(root != null) {
            Inorder(root.left, list);
            if(root.left == null && root.right == null) list.add(root.val);
            Inorder(root.right, list);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Inorder(root1, list1);
        Inorder(root2, list2);
        
        return list1.equals(list2);
    }
}