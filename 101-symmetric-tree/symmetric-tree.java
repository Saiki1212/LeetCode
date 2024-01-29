class Solution {
    public static boolean GetInfo(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        return (r1.val == r2.val) && (GetInfo(r1.left, r2.right)) && (GetInfo(r1.right, r2.left));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return GetInfo(root.left, root.right);
    }
}