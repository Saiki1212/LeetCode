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

    public static void find(List<Integer> list, TreeNode root, int level) {
        if(root == null) return;
        if(list.size() == level) {
            list.add(root.val);
        }
        find(list, root.right, level+1);
        find(list, root.left, level+1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        find(list, root, 0);
        return list;
    }
}