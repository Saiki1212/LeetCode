class Solution {
    public int uniquePaths(int m, int n) {
        int dp_grid[][] = new int[m][n];

        for(int [] dp : dp_grid) Arrays.fill(dp, -1);

        return TotalPossibleWays(m-1, n-1, dp_grid);

    }

    public int TotalPossibleWays(int r, int c, int [][] dp_grid) {

        if(r < 0 || c < 0) return 0;

        if(r == 0 && c == 0) return 1;

        if(dp_grid[r][c] != -1) return dp_grid[r][c];

        return dp_grid[r][c] =  TotalPossibleWays(r-1, c, dp_grid) + TotalPossibleWays(r, c-1, dp_grid);

    }

}