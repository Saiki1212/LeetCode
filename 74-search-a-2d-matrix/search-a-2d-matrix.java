class Solution {
    public boolean searchMatrix(int[][] mat, int tar) {
        int row = mat.length, col = mat[0].length;
        int s = 0, e = row*col-1;

        while( s<=e ) {
            int mid = (s+e)/2;
            int r = mid/col, c = mid%col;
            if(mat[r][c] == tar) return true;
            else if(mat[r][c] > tar) e = mid-1;
            else s = mid+1;
        }
        return false;
    }
}