class Solution {
    public boolean exist(char[][] mat, String word) {
        int row = mat.length, col = mat[0].length;
        // if(word.length() > (row*col)) return false;
        boolean check[][] = new boolean [row][col];

        for(int i=0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                if(mat[i][j] == word.charAt(0)) {
                    // check[i][j] = true;
                    if(isPathPossible(mat, check, i, j, row, col, word, 0)) return true;
                    // check[i][j] = false;
                }
            }
        }
        return false;
    }

    public static boolean isPathPossible(char[][] mat, boolean check[][], int i, int j, int r, int c, String s, int idx) {
        if(idx == s.length()) {
            return true;
        }

        if(i < 0 || i>= r || j<0 || j>=c || check[i][j] || mat[i][j] != s.charAt(idx)) return false;

        // Check TOP...
        check[i][j] = true;
        boolean ans = (isPathPossible(mat, check, i-1, j, r, c, s, idx+1) || 
                        isPathPossible(mat, check, i, j-1, r, c, s, idx+1) || 
                        isPathPossible(mat, check, i+1, j, r, c, s, idx+1) ||
                        isPathPossible(mat, check, i, j+1, r, c, s, idx+1));
        check[i][j] = false;
        return ans;
    }
}