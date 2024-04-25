class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int e = c-1, s = 0;
        
        while( s<= e){
            int mid = (s+e)/2;
            int id1 = 0, pre = mat[0][mid];
            for(int i=1; i<r; i++) {
                if(mat[i][mid] > pre) {
                    pre = mat[i][mid];
                    id1 = i;
                }
            }
            
            if(mid > 0 && mat[id1][mid-1] > mat[id1][mid]) e = mid-1;
            else if(mid < c-1 && mat[id1][mid+1] > mat[id1][mid]) s = mid+1;
            else return new int[]{id1, mid};
        }
        return null;
    }
}