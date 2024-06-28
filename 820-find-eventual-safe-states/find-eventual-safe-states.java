class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        int [] indegree = new int[n];

        for(int i =0; i<n; i++) {
            for(int it : graph[i]) {
                adj.get(it).add(i);
                indegree[i]++;
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<n; i++) if(indegree[i] == 0) dq.add(i);

        while( !dq.isEmpty() ) {
            int idx = dq.pollFirst();
            list.add(idx);

            for(int i : adj.get(idx)) {
                indegree[i]--;
                if(indegree[i] == 0) dq.add(i);
            }
        }

        Collections.sort(list);
        return list;
    }
}