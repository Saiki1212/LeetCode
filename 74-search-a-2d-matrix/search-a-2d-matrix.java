class Solution {
    public boolean searchMatrix(int[][] mat, int tar) {
        int row = mat.length, col = mat[0].length;
        int s = 0, e = row-1, idx = 0;

        while( s<=e ) {
            int m = (s+e)/2;
            idx = m;
            if(mat[m][0] == tar) return true;
            else if(mat[m][0] > tar) e = m-1;
            else if(mat[m][0] < tar && mat[m][col-1] >= tar) {
                break;
            }
            else s = m+1;
        }

        s = 0; e = col-1;
        while( s<=e ) {
            int m = (s+e)/2;
            if(mat[idx][m] == tar) return true;
            else if(mat[idx][m] > tar) e = m-1;
            else s = m+1;
        }
        return false;
    }
}