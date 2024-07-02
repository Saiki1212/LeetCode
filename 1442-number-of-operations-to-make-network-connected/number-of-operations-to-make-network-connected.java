class Solution {

    public void dfs( boolean visited[], List<List<Integer>> adj, int i, int n) {
        if(visited[i]) return;
        visited[i] = true;
        // arr[0]++;
        for(int j : adj.get(i)) {
            // arr[1]++;
            dfs(visited, adj, j, n);
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if(n > connections.length + 1) return-1;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        
        boolean [] visited = new boolean[n];

        for(int [] nums : connections) {
            adj.get(nums[0]).add(nums[1]);
            adj.get(nums[1]).add(nums[0]);
        }
        int components = 0;
        for(int i = 0; i<n; i++) {
            if(visited[i]) continue;
            // int [] arr = new int[2]; // arr[0] == no.of nodes and arr[1] == ni.of edges...
            dfs(visited, adj, i, n);
            components++;
        }


        // int connectionsRequired = 0;

        // for(int i = 0; i<n; i++) {
        //     if(!visited[i]) connectionsRequired++;
        // }
        return components-1;
    }
}