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
        if(root == null) return root;
        while(root != null) {
            int data = root.val;
            if( data == p.val ) return p;
            else if( data == q.val ) return q;

            if( (p.val > data ) &&  (q.val < data) )
                return root;
            if( (p.val < data ) &&  (q.val > data) )
                return root;
            
            if(data < p.val) root = root.right;
            else root = root.left;
        }
        return root;
    }
}