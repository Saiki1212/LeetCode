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

    public static TreeNode find(ArrayList<Integer> list, int s, int e) {
        if(s > e) return null;
        int mid = (s+e)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = find(list, s, mid-1);
        root.right = find(list, mid+1, e);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(list, root);
        return find(list, 0, list.size()-1);
    }


    public static void inorder(ArrayList<Integer> list, TreeNode root) {
        if(root == null) return;
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

}