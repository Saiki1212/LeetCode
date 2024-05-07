class Solution {
    public void solveSudoku(char[][] mat) {
        Solve(mat);
    }

    static boolean Solve(char [][] mat) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(mat[i][j] == '.') {
                    for(char val = '1'; val <= '9'; val++) {
                        if(isSafeToPlace(mat, i, j, val)) {
                            mat[i][j] = val;
                            if(Solve(mat)) return true;
                            else mat[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSafeToPlace(char [][] mat, int i, int j, char c) {
        for(int k=0; k<9; k++) {
            if(mat[k][j] == c) return false;
            if(mat[i][k] == c) return false;
            if(mat[3*(i/3) + k/3][3*(j/3) + k%3] == c) return false;
        }
        return true;
    }
}