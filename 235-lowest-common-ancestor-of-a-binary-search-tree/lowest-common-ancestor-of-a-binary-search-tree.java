/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = null;
        while(root != null) {
            int vr = root.val, vp = p.val, vq = q.val;
            if(vr > vp && vr > vq) root = root.left;
            else if(vr < vp && vr < vq) root = root.right;
            else if((vr > vp && vr < vq) || (vr < vp && vr > vq)) return root;
            else if(vr == vp) return root;
            else if(vr == vq) return root;
        }
        return null;
    }
}