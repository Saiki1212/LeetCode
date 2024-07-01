class Solution {

    public static void convertOneToZero(char [][] grid, int i, int j, int r, int c) {
        if(i < 0 || j < 0 || i>=r || j>=c || grid[i][j] == '0') return;
        grid[i][j] = '0';
        convertOneToZero(grid, i+1, j, r, c);
        convertOneToZero(grid, i, j+1, r, c);
        convertOneToZero(grid, i, j-1, r, c);
        convertOneToZero(grid, i-1, j, r, c);
    }

    public int numIslands(char[][] grid) {
        int r = grid.length, c = grid[0].length;

        int totalIslands = 0;

        for(int i = 0; i<r; i++) {
            for(int j = 0; j<c; j++) {
                if(grid[i][j] == '1') {
                    convertOneToZero(grid, i, j, r, c);
                    totalIslands++;
                }
            }
        }
        return totalIslands;
    }
}