class Solution {
    public void setZeroes(int[][] mat) {
        int row = mat.length, col = mat[0].length;

        boolean r[] = new boolean[row], c[] = new boolean[col];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(mat[i][j] == 0) {
                    r[i] = true;
                    c[j] = true;
                }
            }
        }

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(r[i] || c[j]) {
                    mat[i][j] = 0;
                }
            }
        }

    }
}