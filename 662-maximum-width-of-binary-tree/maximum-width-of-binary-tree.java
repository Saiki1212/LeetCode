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

    public static void pre(TreeNode root, int i) {
        if(root == null) return;
        root.val = i;
        pre(root.left, 2*i+1);
        pre(root.right, 2*i+2);
    }

    public int widthOfBinaryTree(TreeNode root) {
        pre(root, 0);

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        int maxi = -1;

        while(!dq.isEmpty()) {
            int n = dq.size();
            int value = dq.peekLast().val - dq.peekFirst().val + 1;
            maxi = Math.max(maxi, value);

            for(int i=0; i<n; i++) {
                TreeNode node = dq.pollFirst();
                if(node.left != null) dq.add(node.left);
                if(node.right != null) dq.add(node.right);
            }
        }
        return maxi;
    }
}