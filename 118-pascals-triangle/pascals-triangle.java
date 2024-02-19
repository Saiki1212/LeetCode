class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i<=n; i++) {
            list.add(new ArrayList<>());
            for(int j = 1; j <= i; j++) {
                if(j == 1) list.get(i-1).add(1);
                else if(j == i) list.get(i-1).add(1);
                else {
                    int val = list.get(i-2).get(j-2) + list.get(i-2).get(j-1);
                    list.get(i-1).add(val);
                }
            }
        }
        return list;
    }
}