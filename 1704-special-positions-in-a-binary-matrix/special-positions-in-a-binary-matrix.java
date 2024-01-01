class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        for(int i = 0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 1 && isSpecial(mat, n, m, i, j)) 
                    count++;
            }
        }
        return count;
    }

    static boolean isSpecial(int[][] mat, int n, int m, int a, int b) {
        for(int i=0; i<n; i++) {
            if(mat[i][b] == 1 && a != i) return false;
        }
        for(int i=0; i<m; i++) 
            if(mat[a][i] == 1 && b != i) return false;
        return true;
    }
}