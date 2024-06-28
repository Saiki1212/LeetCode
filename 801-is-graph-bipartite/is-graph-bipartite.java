class Solution {
    int [] colors;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        colors = new int[n];
        for(int i=0; i<n; i++) {
            if(colors[i] == 0) {
                if( !dfs(graph, i, 1)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int idx, int color) {
        colors[idx] = color;

        for(int i : graph[idx]) {
            if (colors[i] == color || (colors[i] == 0 && !dfs(graph, i, 3 - color))) {
                return false;
            }
        }
        return true;
    }
}