class Solution {

    class DisJoint_DataStructure {
        private List<Integer> parent;
        private List<Integer> size;

        DisJoint_DataStructure(int n) {
            parent = new ArrayList<>(n);
            size = new ArrayList<>(n);
            for(int i = 0; i<n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        int findParent(int u) {
            if(parent.get(u) != u) {
                parent.set(u, findParent(parent.get(u)));
            }
            return parent.get(u);
        }

        int UnionbySize(int u, int v) {
            int parent_u = findParent(u), parent_v = findParent(v);
            if(parent_u == parent_v) return 1;

            if(size.get(parent_u) < size.get(parent_v)) {
                parent.set(parent_u, parent_v);
                size.set(parent_v, (size.get(parent_u) + size.get(parent_v)));
            }
            else {
                parent.set(parent_v, parent_u);
                size.set(parent_u, (size.get(parent_u) + size.get(parent_v)));
            }
            return 0;
        }

    }

    public int makeConnected(int n, int[][] connections) {
        if(n > connections.length + 1) return-1;

        DisJoint_DataStructure ds = new DisJoint_DataStructure(n);

        int extraEdges = 0, connectedComponents = 0;

        for(int nums[] : connections) {
            if(ds.findParent(nums[0]) != ds.findParent(nums[1])) {
                extraEdges += ds.UnionbySize(nums[0], nums[1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) connectedComponents++;
        }

        return connectedComponents-1;
    }
}