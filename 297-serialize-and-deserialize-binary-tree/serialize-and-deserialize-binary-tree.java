/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Deque<TreeNode> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        dq.offer(root);

        while(!dq.isEmpty()) {
            TreeNode node = dq.poll();
            if(node == null) {
                sb.append("#,");
            }
            else {
                sb.append(node.val).append(",");
                dq.offer(node.left);
                dq.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;

        Deque<TreeNode> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(data);

        int comma = sb.indexOf(",");
        String str = sb.substring(0, comma);
        sb.delete(0, comma + 1);
        TreeNode root = new TreeNode(Integer.parseInt(str));
        dq.offer(root);

        while(!dq.isEmpty()) {
            TreeNode node = dq.poll();
            comma = sb.indexOf(",");
            str = sb.substring(0, comma);
            sb.delete(0, comma+1);

            if (!str.equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(str));
                node.left = leftNode;
                dq.offer(leftNode);
            }

            comma = sb.indexOf(",");
            str = sb.substring(0, comma);
            sb.delete(0, comma + 1);
            if (!str.equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(str));
                node.right = rightNode;
                dq.offer(rightNode);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));