class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int [] adj = new int[n];

        for(int i = 0; i<roads.length; i++) {
            adj[roads[i][0]]++;
            adj[roads[i][1]]++;
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // for(int i : indices) System.out.println(i);
        // System.out.println(" --------------------- ");

        Arrays.sort(indices, (a, b) -> Integer.compare(adj[b], adj[a]));

        // for(int i : indices) System.out.println(i);
        // System.out.println(" --------------------- ");


        int values[] = new int[n];

        for(int i = 0; i<n; i++) {
            values[indices[i]] = n-i;
        }

        // for(int i : values) System.out.println(i);
        // System.out.println(" --------------------- ");


        long maxImportance = 0;

        for(int road[] : roads) {
            maxImportance += values[road[0]] + values[road[1]];
        }
        return maxImportance;
    }
}