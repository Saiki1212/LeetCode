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

    public void MakeParents(TreeNode root, int startVal, TreeNode parent) {
        if(root == null) return;
        if(root.val == startVal) startNode = root;
        map.put(root, parent);
        MakeParents(root.left, startVal, root);
        MakeParents(root.right, startVal, root);
    }

    public boolean FindThePath(TreeNode start, int destination, StringBuilder path) {
        if(start == null || visited.contains(start.val)) return false;

        visited.add(start.val);

        if(start.val == destination) {
            ans = path.toString();
            return true;
        }

        // Left Move
        path.append('L');
        if(FindThePath(start.left, destination, path)) return true;
        path.deleteCharAt(path.length() - 1);

        // Right Move
        path.append('R');
        if(FindThePath(start.right, destination, path)) return true;
        path.deleteCharAt(path.length() - 1);

        //Top Move
        path.append('U');
        if(FindThePath(map.get(start), destination, path)) return true;
        path.deleteCharAt(path.length() - 1);

        visited.remove(start.val);
        return false;
    }

    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    TreeNode startNode = null;
    String ans = "";
    Set<Integer> visited = new HashSet<>();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        MakeParents(root, startValue, null);
        FindThePath(startNode, destValue, new StringBuilder());
        return ans;
    }
}