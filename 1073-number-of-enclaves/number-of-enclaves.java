class Solution {
    class Point{
        int x, y;
        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public void bfsTraversal(int[][] grid, int r, int c) {
        while(!dq.isEmpty()) {

            int n = dq.size();

            for(int a = 0; a<n; a++) {

                Point point  = dq.pollFirst();
                int x = point.x, y = point.y;

                for(int i = 0; i<4; i++) {
                    int xx = x + row4[i], yy = y + col4[i];
                    if(xx<0 || yy<0 || xx>=r || yy>=c || grid[xx][yy] != 1) continue;
                    grid[xx][yy] = 2;
                    dq.add(new Point(xx, yy));
                }
            }
        }
    }

    Deque<Point> dq = new ArrayDeque<>();
    int row4[] = {-1, 0, 0, 1};
    int col4[] = {0, -1, 1, 0};

    public int numEnclaves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;


        for(int i=0; i<r; i++) {
            if(grid[i][0] == 1) {
                grid[i][0] = 2;
                dq.add(new Point(i, 0));
            }
                
            if(grid[i][c-1] == 1) {
                grid[i][c-1] = 2;
                dq.add(new Point(i, c-1));
            }
        }

        for(int i = 0; i<c; i++) {
            if(grid[0][i] == 1) {
                grid[0][i] = 2;
                dq.add(new Point(0, i)); 
            }
            if(grid[r-1][i] == 1) {
                grid[r-1][i] = 2;
                dq.add(new Point(r-1, i));
            }
        }

        bfsTraversal(grid, r, c);

        int totalIslands = 0;

        for(int i=0; i<r; i++) {
            for(int j = 0; j<c; j++) {
                if(grid[i][j] == 1) totalIslands++;
                else if(grid[i][j] == 2) grid[i][j] = 1;
            }
        }
        return totalIslands;
    }

    // public static void dfs(int [][] grid, int i, int j, int r, int c) {
    //     if(i<0 || j<0 || i>=r || j>=c || grid[i][j] != 1) return;
    //     grid[i][j] = 2;
    //     dfs(grid, i-1, j, r, c);
    //     dfs(grid, i+1, j, r, c);
    //     dfs(grid, i, j-1, r, c);
    //     dfs(grid, i, j+1, r, c);
    // }
}