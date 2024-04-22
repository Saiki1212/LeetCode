class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int j=0;
            List<Integer> list = new ArrayList<>();
            while(j <= i) {
                if(j == 0) list.add(1);
                else if(j == i) list.add(1);
                else {
                    int val = res.get(i-1).get(j-1) + res.get(i-1).get(j);
                    list.add(val);
                }
                j++;
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}