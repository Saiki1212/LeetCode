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

    public static int idxInInorder(int [] in, int tar, int s, int e) {
        while(s <= e) {
            if(in[s] == tar) return s;
            if(in[e] == tar) return e;
            s++; e--;
        }
        return -1;
    }

    public static TreeNode Mytree(int[] pre, int[] in, int s, int e, int ps, int pe) {
        if(s>e || ps>pe) return null;
        TreeNode root = new TreeNode(pre[ps]);

        int idx = idxInInorder(in, pre[ps], s, e);

        root.left = Mytree(pre, in, s, idx-1, ps+1, ps+idx-s);
        root.right = Mytree(pre, in, idx+1, e, ps+idx-s+1, pe);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return Mytree(preorder, inorder, 0, n-1, 0, n-1);
    }
}