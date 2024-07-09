class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;

        int wt = customers[0][0] + customers[0][1];
        long sum = wt - customers[0][0];

        for(int i=1; i<n; i++) {
            if(wt < customers[i][0]) wt = customers[i][0] + customers[i][1];
            else wt += customers[i][1];
            sum += (wt - customers[i][0]);
        }
        double dd = (double)sum/(double)n;
        return dd;
    }
}