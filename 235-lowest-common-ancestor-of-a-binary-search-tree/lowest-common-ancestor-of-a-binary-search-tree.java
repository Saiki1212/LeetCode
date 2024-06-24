/**
 * Definition for a binary search tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode r, TreeNode p, TreeNode q) {
        if(r.val > p.val && r.val > q.val) return lowestCommonAncestor(r.left, p, q);
        else if(r.val < p.val && r.val < q.val) return lowestCommonAncestor(r.right, p, q);
        return r;
    }
}