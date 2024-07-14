class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;

        int [] min_sum_dp = new int[n];

        for(int i = 0; i<n; i++) min_sum_dp[i] = mat[0][i];

        for(int i = 1; i<n; i++) {
            int [] dp = new int[n];

            dp[0] = Math.min(min_sum_dp[0], min_sum_dp[1]) + mat[i][0];
            for(int j = 1; j<n-1; j++) {
                int minVal = Integer.MAX_VALUE;
                minVal = Math.min(min_sum_dp[j], min_sum_dp[j+1]);
                minVal = Math.min(minVal, min_sum_dp[j-1]);
                dp[j] = minVal + mat[i][j];
            }

            dp[n-1] = Math.min(min_sum_dp[n-1], min_sum_dp[n-2]) + mat[i][n-1];
            min_sum_dp = dp;
        }

        int min = Integer.MAX_VALUE;
        for(int i : min_sum_dp) {
            if(min > i) min = i;
        }
        return min;

    }
}