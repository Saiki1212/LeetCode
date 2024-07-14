class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int dp_sum[][] = new int[m][n];

        return MinSumFromtheGrid(grid, dp_sum, m-1, n-1);
    }

    public int MinSumFromtheGrid(int[][] grid, int [][] dp_sum, int i, int j) {
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return (int)Math.pow(10, 9);

        if(dp_sum[i][j] != 0) return dp_sum[i][j];

        int prev_min_sum = Math.min(MinSumFromtheGrid(grid, dp_sum, i-1, j), MinSumFromtheGrid(grid, dp_sum, i, j-1));

        return dp_sum[i][j] = prev_min_sum + grid[i][j];
    }

}