class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int r = rowSum.length, c = colSum.length;
        int [][] mat = new int[r][c];
        int i = 0, j = 0;
        while(i<r && j<c) {
            mat[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] -= mat[i][j];
            colSum[j] -= mat[i][j];

            if(rowSum[i] == 0) i++;
            else j++;

        }
        return mat;
    }
}

    //.  [[6,1,1],[0,1,1]]
    //.   [[0,9,5],[6,0,3]]

        //   0  8  1
        //   a  b  c  0
        //   d  e  f  8


        //   6  1  7
        //   0  1