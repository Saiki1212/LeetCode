class Solution {
    public int[][] transpose(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int [][] res = new int[col][row];
        for(int i=0; i<col; i++) {
            for(int j=0; j<row; j++) {
                res[i][j] = mat[j][i];
            }
        }
        return res;
    }
}