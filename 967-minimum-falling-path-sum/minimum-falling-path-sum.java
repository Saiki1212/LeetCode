class Solution {
    // static int [][] dp;
    // public int minFallingPathSum(int[][] mat) {
    //     int row = mat.length;
    //     dp = new int[row][row];
    //     for(int d[] : dp) Arrays.fill(d, -1);
    //     return MinPath(mat, row, 0, 0);
    // }
    // public static int MinPath(int[][] mat, int n, int row, int col) {
    //     if(col < 0 || col >= n )
    //         return Integer.MAX_VALUE;
    //     if(row == n-1)
    //         return mat[row][col];
        
    //     if(dp[row][col] != -1)
    //         return dp[row][col];
    //     int dleft = mat[row][col] + MinPath(mat, n, row+1, col-1);
    //     int d = mat[row][col] + MinPath(mat, n, row+1, col);
    //     int dright = mat[row][col] + MinPath(mat, n, row+1, col+1);
    //     d = Math.min(dleft, d);
    //     d = Math.min(d, dright);
    //     return dp[row][col] = d;
    // }

    public int minFallingPathSum(int[][] mat) {
        int row = mat.length;
        List <Integer> list = new ArrayList<>();
        for(int i=0; i<row; i++) {
            list.add(mat[0][i]);
        }
        for(int i=1; i<row; i++) {
            List <Integer> temp = new ArrayList<>();
            int minValue = Math.min(list.get(0), list.get(1));
            temp.add(minValue + mat[i][0]);
            for(int j=1; j<row-1; j++) {
                minValue = Math.min(list.get(j-1), list.get(j+1));
                minValue = Math.min(list.get(j), minValue);
                temp.add(minValue + mat[i][j]);
            }
            minValue = Math.min(list.get(row-1), list.get(row-2));
            temp.add(minValue + mat[i][row-1]);
            list = temp;
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0; i<list.size(); i++) {
            if(mini > list.get(i))
                mini = list.get(i);
        }
        return mini;
    }
}