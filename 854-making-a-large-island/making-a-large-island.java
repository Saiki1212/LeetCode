class Solution {

    private List<Integer> parent;
    private List<Integer> size;

    int findParent(int u) {
        if(parent.get(u) == u) return u;
        int pp = findParent(parent.get(u));
        parent.set(u, pp);
        return parent.get(u);
    }

    void UnionOfNodes(int u, int v) {
        int pu = findParent(u), pv = findParent(v);
        if(pu == pv) return;
        if(size.get(pu) > size.get(pv)) {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
        else {
            parent.set(pu, pv);
            size.set(pv, size.get(pu) + size.get(pv));
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0; i<n*n; i++) {
            parent.add(i);
            size.add(1);
        }


        for(int i=0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 0) continue;
                int []dr = {-1, 0, 0, 1};
                int []cr = {0, 1, -1, 0};
                for(int k = 0; k<4; k++) {
                    int x = dr[k] + i, y = cr[k] + j;

                    if(x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 0) continue;
                    
                    UnionOfNodes(n * i + j, n * x + y);

                }
            }
        }

        int maxi = 0;
        boolean hasZeros = false;
        for(int i=0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 1) continue;
                hasZeros = true;
                int []dr = {-1, 0, 0, 1};
                int []cr = {0, 1, -1, 0};

                int total = 1;
                Set<Integer> seen = new HashSet<>();
                for(int k = 0; k<4; k++) {
                    int x = dr[k] + i, y = cr[k] + j;

                    if(x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 0) continue;

                    int root = findParent(x * n + y);
                    if (!seen.contains(root)) {
                        total += size.get(root);
                        seen.add(root);
                    }

                }

                maxi = Math.max(total, maxi);
            }
        }

        return hasZeros ? maxi : n*n;

    }
}