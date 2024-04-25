class Solution {
    public boolean searchMatrix(int[][] mat, int tar) {
        int row = mat.length, col = mat[0].length;
        
        int s = 0, e = col-1;
        while(s<row && e>=0) {
            if(mat[s][e] == tar) return true;
            else if(mat[s][e] > tar) e--;
            else s++;
        }
        return false;
    }
}