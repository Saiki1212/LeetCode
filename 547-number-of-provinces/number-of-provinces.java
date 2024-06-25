class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean visited[] = new boolean[n+1];

        int provinces = 0;

        for(int i = 1; i<= n; i++) {
            if(visited[i]) continue;
            provinces ++;
            traverseNodes(isConnected, visited, i, n);
        }

        return provinces;

    }

    public static void traverseNodes(int[][] adj, boolean visited[], int n, int col) {
        visited[n] = true;

        for(int i=0; i<col; i++) {
            int val = adj[n-1][i];
            if(val == 0 || visited[i+1]) continue;
            traverseNodes(adj, visited, i+1, col);
        }
    }

}