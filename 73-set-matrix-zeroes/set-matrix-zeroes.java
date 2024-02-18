class Solution {

    public void setZeroes(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        boolean [] checkrow = new boolean [row];
        boolean [] checkcol = new boolean [col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    checkrow[i] = true;
                    checkcol[j] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            if(checkrow[i]) {
                for(int j = 0; j<col; j++)
                    mat[i][j] = 0;
            }
        }

        for (int i = 0; i < col; i++) {
            if(checkcol[i]) {
                for(int j = 0; j<row; j++)
                    mat[j][i] = 0;
            }
        }
    }
}