class Solution {
    public boolean searchMatrix(int[][] mat, int tar) {
        int row = mat.length, col = mat[0].length;
        
        for(int i=0; i<row; i++) {
            // System.out.println(i);
            if(mat[i][0] <= tar && mat[i][col-1] >= tar) {
                int s = 0, e = col-1;
                while(s <= e) {
                    int m = (s+e)/2;
                    // System.out.println(m + " --- m");
                    if(mat[i][m] == tar) return true;
                    else if(mat[i][m] > tar) e = m-1;
                    else s = m+1;
                }
            }
        }
        return false;
    }
}