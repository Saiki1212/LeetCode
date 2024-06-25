class Solution {
    class Point{
        int x, y;
        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        Deque<Point> dq = new ArrayDeque<>();

        for(int i=0; i<r; i++) {
            for(int j = 0; j<c; j++) {
                if(grid[i][j] == 2) {
                    dq.add(new Point(i, j));
                }
            }
        }

        int time = 0;
        
        while(!dq.isEmpty()) {
            int n = dq.size();
            boolean flag = false;
            for(int i=0; i<n; i++) {
                Point idx = dq.poll();
                int x = idx.x, y = idx.y;

                //Top....
                if(x > 0 && grid[x-1][y] == 1) {
                    flag = true;
                    grid[x-1][y] = 2;
                    dq.add(new Point(x-1, y));
                }

                //Left.....
                if(y > 0 && grid[x][y-1] == 1) {
                    flag = true;
                    grid[x][y-1] = 2;
                    dq.add(new Point(x, y-1));
                }

                //Right....
                if(y < c-1 && grid[x][y+1] == 1) {
                    flag = true;
                    grid[x][y+1] = 2;
                    dq.add(new Point(x, y+1));
                }

                //Bottom....
                if(x < r-1 && grid[x+1][y] == 1) {
                    flag = true;
                    grid[x+1][y] = 2;
                    dq.add(new Point(x+1, y));
                }
            }
            if(flag) time++;
        }
        return isRotted(grid, r, c) ? time : -1;
    }

    public static boolean isRotted(int [][] grid, int r, int c) {
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 1) return false;
            }
        }
        return true;
    }

}