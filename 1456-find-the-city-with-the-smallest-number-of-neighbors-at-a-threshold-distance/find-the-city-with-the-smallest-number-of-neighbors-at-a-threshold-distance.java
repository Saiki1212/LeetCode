class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int graph[][] = new int[n][n];
        int intMax = (int)(1e8);

        for(int e[] : edges) {
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }

        for(int i=0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(graph[i][j] == 0) graph[i][j] = intMax;
            }
        }

        for(int k = 0; k<n; k++) {
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }

        int dist = intMax, city = -1;
        for(int i = n-1; i>=0; i--) {
            int sum = 0;
            for(int j = 0; j<n; j++) {
                if(i == j) continue;
                if(distanceThreshold >= graph[i][j]) sum++;
            }
            if(sum < dist) {
                // System.out.println(dist + " -- " + city + "  --  " + sum);
                dist = sum;
                city = i;
            }
        }
        return city;
    }
}