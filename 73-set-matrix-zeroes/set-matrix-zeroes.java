class Solution {
    public void setZeroes(int[][] mat) {
        int row = mat.length, col = mat[0].length;

        int r[] = new int[row], c[] = new int[col];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(mat[i][j] == 0) {
                    r[i] = 1;
                    c[j] = 1;
                }
            }
        }

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(r[i] == 1 || c[j] == 1) {
                    mat[i][j] = 0;
                }
            }
        }

    }
}