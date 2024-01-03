class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        int i = 0, j = n-1;
        while(i<n && j>=0) {
            if(grid[i][i] == 0) return false;
            if(grid[i][j] == 0) return false;
            for(int a = 0; a<n; a++) {
                if(a == i || a == j) continue;
                if(grid[i][a] != 0) return false;
            }
            i++; j--;
        }
        return true;
    }
}