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
    public TreeNode createBinaryTree(int[][] des) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int node_details[] : des) {
            int parentVal = node_details[0];
            int childVal = node_details[1];
            boolean isLeft = node_details[2] == 1;

            TreeNode parent = map.computeIfAbsent(parentVal, k -> new TreeNode(parentVal));
            TreeNode child = map.computeIfAbsent(childVal, k -> new TreeNode(childVal));

            set.add(childVal);

            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        for(int i[] : des) {
            if(!set.contains(i[0])) {
                return map.get(i[0]);
            }
        }
        return null;

    }
}