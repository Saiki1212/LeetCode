class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] mat = new int[row][col];
        int []a = new int [row];
        int []b = new int [col];
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == 1)
                    a[i]++;
                else
                    a[i]--;
            }
        }
        for(int i=0; i<col; i++) {
            for(int j=0; j<row; j++) {
                if(grid[j][i] == 1)
                    b[i]++;
                else
                    b[i]--;
            }
        }

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                mat[i][j] = a[i] + b[j];
            }
        }
        return mat;
    }
}