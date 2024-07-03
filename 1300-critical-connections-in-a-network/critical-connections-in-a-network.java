class Solution {

    private int[] reach;
    private int[] low;
    private boolean[] visited;
    private int index;
    private List<List<Integer>> res;
    private List<List<Integer>> adj;

    public void dfs(int idx, int parent) {
        visited[idx] = true;
        reach[idx] = low[idx] = index++;
        for(int i : adj.get(idx)) {
            if (i == parent) continue;
            if(!visited[i]) {
                dfs(i, idx);
                low[idx] = Math.min(low[idx], low[i]);
                if(low[i] > reach[idx]) res.add(Arrays.asList(i, idx));
            }
            else {
                low[idx] = Math.min(low[idx], reach[i]);
            }
        }

    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> points) {
        if(n == 2) return points;
        reach = new int[n];
        low = new int[n];
        visited = new boolean[n];
        adj = new ArrayList<>();
        res = new ArrayList<>();
        index = 0;

        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());

        for(List<Integer> list : points) {
            adj.get(list.get(0)).add(list.get(1));
            adj.get(list.get(1)).add(list.get(0));
        }


        dfs(0, -1);

        return res;

    }
}