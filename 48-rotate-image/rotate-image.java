class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;
        int [][] res = new int[n][n];
        int i1 = n-1, j1 = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                res[j1][i1] = mat[i][j];
                j1++;
            }
            i1--;
            j1 = 0;
        }
        for(int i=0; i<n; i++) {
            for(int j = 0; j<n; j++)
                mat[i][j] = res[i][j];
        }
    }
}