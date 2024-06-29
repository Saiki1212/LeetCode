class Solution {

    class Pair{
        int x, y, w;
        Pair(int _x, int _y, int _w) {
            x = _x;
            y = _y;
            w = _w;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length;
        if(grid[0][0] == 1 || grid[r-1][r-1] == 1) return -1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.add(new Pair(0, 0, 1));
        grid[0][0] = 1;

        while( !pq.isEmpty() ) {
            Pair p = pq.remove();
            if(p.x == r-1 && p.y == r-1) return p.w;
            int drow[] = {-1, -1, -1, 0, 0, 1, 1, 1};
            int dcol[] = {-1, 0, 1, -1, 1, -1, 0, 1};
            for(int i = 0; i<8; i++) {
                int xx = drow[i] + p.x, yy = dcol[i] + p.y;
                if( xx < 0 || yy < 0 || xx >= r || yy >= r || grid[xx][yy] == 1 ) continue;
                pq.add(new Pair(xx, yy, p.w+1));
                grid[xx][yy] = 1;
            }
        }
        return -1;
    }
}