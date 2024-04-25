class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int e = r*c;
        int id1 = 0, id2 = 0;
        for(int in = 0; in <= e; in++) {
            int i = id1, j = id2;
            
            if(i > 0 && mat[i][j] < mat[i-1][j]) {
                id1 = i-1; id2 = j;
            }
            if(i<r-1 && mat[i][j] < mat[i+1][j]) {
                if(mat[i+1][j] > mat[id1][id2]) {
                    id1 = i+1; id2 = j;
                }
            }
            if(j > 0 && mat[i][j] < mat[i][j-1]) {
                if(mat[i][j-1] > mat[id1][id2]) {
                    id1 = i; id2 = j-1;
                }
            }
            if(j < c-1 && mat[i][j] < mat[i][j+1]) {
                if(mat[i][j+1] > mat[id1][id2]) {
                    id1 = i; id2 = j+1;
                }
            }
            if(id1 == i && id2 == j) return new int[]{i, j};
        }
        return null;
    }
}