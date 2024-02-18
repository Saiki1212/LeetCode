class Solution {

    public void setZeroes(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        boolean [][] check = new boolean [row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    check[i][j] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (check[i][j]) {
                    mat[i][j] = 0;
                    for(int a = 0; a < row; a++) {
                        mat[a][j] = 0;
                        // check[a][j] = false;
                    }
                    for(int a = 0; a < col; a++) {
                        mat[i][a] = 0;
                        // check[i][a] = false;
                    }
                }
            }
        }
    }
}