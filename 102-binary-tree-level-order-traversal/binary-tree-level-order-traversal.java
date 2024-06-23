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
    List<List<Integer>> li = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        trav(root,0);
        return li;
    }

    public void trav(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        if(level == li.size()) {
            li.add(new ArrayList<>());
        }
        li.get(level).add(root.val);
        trav(root.left,level+1);
        trav(root.right,level+1);
    }
}