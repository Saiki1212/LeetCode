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
            if(map.containsKey(node_details[0])) {
                TreeNode parent = map.get(node_details[0]);
                if(!map.containsKey(node_details[1])) {
                    map.put(node_details[1], new TreeNode(node_details[1]));   
                }
                set.add(node_details[1]);
                TreeNode child = map.get(node_details[1]);
                if(node_details[2] == 0) parent.right = child;
                else parent.left = child;
            }
            else {
                TreeNode parent = new TreeNode(node_details[0]);
                map.put(node_details[0], parent);
                if(!map.containsKey(node_details[1])) {
                    map.put(node_details[1], new TreeNode(node_details[1]));   
                }
                set.add(node_details[1]);
                TreeNode child = map.get(node_details[1]);
                if(node_details[2] == 0) parent.right = child;
                else parent.left = child;
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