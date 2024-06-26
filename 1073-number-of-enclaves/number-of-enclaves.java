class Solution {

    public static void dfs(int [][] grid, int i, int j, int r, int c) {
        if(i<0 || j<0 || i>=r || j>=c || grid[i][j] != 1) return;
        grid[i][j] = 2;
        dfs(grid, i-1, j, r, c);
        dfs(grid, i+1, j, r, c);
        dfs(grid, i, j-1, r, c);
        dfs(grid, i, j+1, r, c);
    }


    public int numEnclaves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        for(int i=0; i<r; i++) {
            if(grid[i][0] == 1) dfs(grid, i, 0, r, c);
            if(grid[i][c-1] == 1) dfs(grid, i, c-1, r, c);
        }

        for(int i = 0; i<c; i++) {
            if(grid[0][i] == 1) dfs(grid, 0, i, r, c);
            if(grid[r-1][i] == 1) dfs(grid, r-1, i, r, c);
        }

        int totalIslands = 0;

        for(int i=0; i<r; i++) {
            for(int j = 0; j<c; j++) {
                if(grid[i][j] == 1) totalIslands++;
                else if(grid[i][j] == 2) grid[i][j] = 1;
            }
        }
        return totalIslands;
    }
}