class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);

        while(!dq.isEmpty()) {
            int n = dq.size();

            for(int i=0; i<n; i++) {
                TreeNode node = dq.pollFirst();
                if(node.left != null) dq.add(node.left);
                if(node.right != null) dq.add(node.right);
                if(i == n-1) list.add(node.val);
            }

        }
        return list;
    }
}