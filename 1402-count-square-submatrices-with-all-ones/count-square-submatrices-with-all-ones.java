class Solution {
    public int countSquares(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int [][] dp = new int[row][col];
        int count = 0;
        for(int i=0; i<col; i++) {
            dp[0][i] = mat[0][i];
            count += mat[0][i];
        }

        for(int i=1; i<row; i++) {
            dp[i][0] = mat[i][0];
            count += mat[i][0];
        }

        for(int i=1; i<row; i++) {
            for(int j = 1; j<col; j++) {
                if(mat[i][j] == 0) continue;
                dp[i][j] = 1 + (Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])));
                count += dp[i][j];
            }
        }
        return count;
    }
}