class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        List<Integer> orderRows = topoSort(k, rowConditions);
        List<Integer> orderCols = topoSort(k, colConditions);

        if(orderRows.isEmpty() || orderCols.isEmpty()) return new int[0][0];

        int [][] mat = new int[k][k];

        for(int i = 0; i<k; i++) {
            for(int j = 0; j<k; j++) {
                if(orderRows.get(i).equals(orderCols.get(j))) {
                    mat[i][j] = orderRows.get(i);
                }
            }
        }

        return mat;

    }

    public List<Integer> topoSort(int k, int [][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> topoSort = new ArrayList<>();

        for(int i = 0; i<=k; i++) adj.add(new ArrayList<>());

        for(int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean hasCycle[] = {false};
        int[] visited = new int[k+1];

        for(int i = 1; i<=k; i++) {
            if(visited[i] == 0) {
                dfs(visited, hasCycle, i, topoSort, adj);
                if(hasCycle[0]) return new ArrayList<>();
            }
        }
        Collections.reverse(topoSort);
        return topoSort;
    }

    public void dfs(int[] visited, boolean[] hasCycle, int i, List<Integer> topoSort, List<List<Integer>> adj) {
        visited[i] = 1;

        for(int edge : adj.get(i)) {
            if(visited[edge] == 0) {
                dfs(visited, hasCycle, edge, topoSort, adj);
                if(hasCycle[0]) return;
            }
            else if(visited[edge] == 1) {
                hasCycle[0] = true;
                return;
            }
        }
        visited[i] = 2;
        topoSort.add(i);
    }

}