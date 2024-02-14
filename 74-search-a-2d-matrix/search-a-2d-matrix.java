class Solution {
    public static boolean fun(int [][] mat, int row, int e, int tar) {
        int s = 0;
        e--;
        while(s <= e) {
            int m = (s+e)/2;
            if(mat[row][m] == tar) return true;
            if(mat[row][m] > tar) e = m-1;
            else s = m+1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] mat, int tar) {
        int row = mat.length, col = mat[0].length;
        for(int i=0; i<row; i++) {
            for(int j = 0; j<col; j++)
                if(mat[i][j] == tar) return true;
        }
        return false;
    }
}