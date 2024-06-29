class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Perform DFS to find all ancestors for each node
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(i, i, adj, res, visited);
        }

        // Sort the ancestor lists
        // for (List<Integer> list : res) {
        //     Collections.sort(list);
        // }

        return res;
    }

    private void dfs(int start, int current, List<List<Integer>> adj, List<List<Integer>> res, boolean[] visited) {
        for (int neighbor : adj.get(current)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                res.get(neighbor).add(start);
                dfs(start, neighbor, adj, res, visited);
            }
        }
    }
}