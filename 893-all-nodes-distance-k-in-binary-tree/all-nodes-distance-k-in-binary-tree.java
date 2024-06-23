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

    // public static void findBelow(List<Integer> list, TreeNode root, int k, int i) {
    //     if(root == null) return;
    //     if(i == k) list.add(root.val);

    //     if(i < k) {
    //         findBelow(list, root.left, k, i+1);
    //         findBelow(list, root.right, k, i+1);
    //     }
    // }

    // public static void findUp(HashMap<TreeNode, TreeNode> map, List<Integer> list, TreeNode root, int i, int k) {
    //     if(root == null) return;
    //     if(i == k) list.add(root.val);
    //     if(i < k) {

    //     }
    // }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        if(k == 0) {
            list.add(target.val);
            return list;
        }
        // findBelow(list, target, k, 0);

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);

        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        // storing node and the parent ... saiki...
        map.put(root, null);

        while(!dq.isEmpty()) {
            int n = dq.size();
            for(int i=0; i<n; i++) {
                TreeNode node = dq.pollFirst();
                if(node.left != null) {
                    map.put(node.left, node);
                    dq.add(node.left);
                }
                if(node.right != null) {
                    map.put(node.right, node);
                    dq.add(node.right);
                }
            }
        }

        

        // findUp(map, list, map.get(target), 1, k);

        ArrayList<TreeNode> visited = new ArrayList<>();
        dq.add(target);
        int dist = 0;

        while(!dq.isEmpty()) {
            int n = dq.size();
            dist++;
            for(int i=0; i<n; i++) {
                TreeNode node = dq.pollFirst();
                if(node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    dq.add(node.left);
                }
                if(node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    dq.add(node.right);
                }
                TreeNode node2 = map.get(node);
                if(node2 != null && !visited.contains(node2)) {
                    visited.add(node2);
                    dq.add(node2);
                }
                if(!visited.contains(node)) visited.add(node);
            }
            if(dist == k) {
                while(!dq.isEmpty()) {
                    list.add(dq.pollLast().val);
                }
                return list;
            }
        }

        return list;
    }
}