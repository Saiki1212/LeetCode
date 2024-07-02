class Solution {

    private List<Integer> parent;
    private List<Integer> size;

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


    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        if(n == 1) return accounts;
        parent = new ArrayList<>(n);
        size = new ArrayList<>(n);

        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i=0; i<n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!map.containsKey(mail)) {
                    map.put(mail, i);
                } else {
                    unionBySize(i, map.get(mail));
                }
            }
        }

        ArrayList<String>[] newList = new ArrayList[n];
        for (int i = 0; i < n; i++) newList[i] = new ArrayList<String>();
        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int node = findUPar(it.getValue());
            newList[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (newList[i].size() == 0) continue;
            Collections.sort(newList[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : newList[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;

    }
}