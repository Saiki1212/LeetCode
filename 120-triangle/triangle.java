class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        List<Integer> triangle_dp = new ArrayList<>();

        triangle_dp.add(triangle.get(0).get(0));

        for(int i = 1; i<n; i++) { 
            List<Integer> temp = triangle.get(i);
            for(int j = 0; j<temp.size(); j++) {
                if(j == 0) {
                    temp.set(j, temp.get(j) + triangle_dp.get(j));
                    continue;
                }
                if(j == temp.size()-1) {
                    temp.set(j, temp.get(j) + triangle_dp.get(j-1));
                    continue;
                }
                int nextSmaller = Math.min(triangle_dp.get(j), triangle_dp.get(j-1));
                temp.set(j, temp.get(j) + nextSmaller);
            }
            triangle_dp = temp;
        }

        int mini = 10001;
        for(int i : triangle_dp) mini = Math.min(mini, i);
        return mini;
    }
}