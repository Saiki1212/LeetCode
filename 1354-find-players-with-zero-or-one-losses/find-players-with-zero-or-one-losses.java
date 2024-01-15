class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        List<List<Integer>> list = new ArrayList<>(2);
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        int[] losses = new int[100001];

        for(int i=0; i<n; i++) {
            int won = matches[i][0];
            int lost = matches[i][1];

            if(losses[won] == 0)
                losses[won] = -1;

            if(losses[lost] == -1)
                losses[lost] = 1;
            else
                losses[lost]++;
        }

        for (int i = 0; i < losses.length; i++) {
            if (losses[i] == -1) {
                list.get(0).add(i);
            } else if (losses[i] == 1) {
                list.get(1).add(i);
            }
        }
        return list;
    }
}