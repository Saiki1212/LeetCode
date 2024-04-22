class Solution {
    public void setZeroes(int[][] mat) {
        int row = mat.length, col = mat[0].length;

        int large = Integer.MIN_VALUE-10;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(mat[i][j] == 0) {
                    for(int a = 0; a<row; a++) {
                        if(mat[a][j] != 0)
                        mat[a][j] = large;
                    }
                    for(int a = 0; a<col; a++) {
                        if(mat[i][a] != 0)
                        mat[i][a] = large;
                    }
                }
            }
        }

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(mat[i][j] == large) {
                    mat[i][j] = 0;
                }
            }
        }

    }
}