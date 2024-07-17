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

    // public void addRoots(TreeNode root, List<Integer> delete, TreeNode parent) {
    //     if(root == null) {
    //         if(!ans.contains(parent) && parent != null) ans.add(parent);
    //         return;
    //     }

    //     if(root.left != null && delete.contains(root.left.val)) {
    //         if(!ans.contains(parent) && parent != null) ans.add(parent);
    //         TreeNode next = root.left;
    //         root.left = null;
    //         addRoots(next.left, delete, next.left);
    //         addRoots(next.right, delete, next.right);
    //     }

    //     if(root.right != null && delete.contains(root.right.val)) {
    //         if(!ans.contains(parent) && parent != null) ans.add(parent);
    //         TreeNode next = root.right;
    //         root.right = null;
    //         addRoots(next.left, delete, next.left);
    //         addRoots(next.right, delete, next.right);
    //     }

    //     if(delete.contains(root.val)) {
    //         if(parent == root) return;
    //         else if(!ans.contains(parent) && parent != null) ans.add(parent);
    //     }
    //     addRoots(root.left, delete, parent);
    //     addRoots(root.right, delete, parent);

    // }

    private List<TreeNode> result;
    private Set<Integer> toDeleteSet;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        result = new ArrayList<>();
        toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        if (!toDeleteSet.contains(root.val)) {
            result.add(root);
        }
        traverse(root, null, false);
        return result;
    }

    private void traverse(TreeNode node, TreeNode parent, boolean isLeftChild) {
        if (node == null) {
            return;
        }
        traverse(node.left, node, true);
        traverse(node.right, node, false);
        
        if (toDeleteSet.contains(node.val)) {
            if (node.left != null) {
                result.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right);
            }
            if (parent != null) {
                if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
    }
}