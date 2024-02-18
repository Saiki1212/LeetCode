class Solution {

    public void setZeroes(int[][] mat) {
        int row = mat.length, col = mat[0].length, col0 = 3;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    if(j != 0) mat[0][j] = 0;
                    else col0 = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for(int j = 1; j<col; j++) {
                if(mat[i][j] != 0) {
                    if (mat[i][0] == 0  || mat[0][j] == 0 ) {
                        mat[i][j] = 0 ;
                    }
                }
            }
        }
        
        if(mat[0][0] == 0) {
            for(int i = 0; i<col; i++) {
                mat[0][i] = 0;
            }
        }
        if(col0 == 0) {
            for(int i = 0; i<row; i++) {
                mat[i][0] = 0;
            }
        }
        
    }
}