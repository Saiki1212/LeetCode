class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        if(n == 1) return 0;
        int dist = 0;
        for(int i=0; i<n-1; i++) {
            int cx = points[i][0];
            int cy = points[i][1];

            int tx = points[i+1][0];
            int ty = points[i+1][1];
            dist += Math.max(Math.abs(cx-tx), Math.abs(cy-ty));
        }
        return dist;
    }
}