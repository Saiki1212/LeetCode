class Solution {


    class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        
        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }



    public int removeStones(int[][] stones) {
        int n = stones.length;
        if(n == 1) return 0;

        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet dj_s = new DisjointSet(maxRow + maxCol + 1);
        Map<Integer, Integer> stoneNodes = new HashMap<>();

        for(int [] edge : stones) {
            int r = edge[0];
            int c = edge[1] + maxRow + 1;
            dj_s.unionBySize(r, c);
            stoneNodes.put(r, 1);
            stoneNodes.put(c, 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            if (dj_s.findUPar(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }
        return n - cnt;
    }
}