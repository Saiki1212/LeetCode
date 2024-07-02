class Solution {

    class Tuple {
        int x, y, w;
        Tuple(int _x, int _y, int _w) {
            x = _x;
            y = _y;
            w = _w;
        }
    }


    public int swimInWater(int[][] grid) {
        int n = grid.length, res = 0;

        boolean visited[][] = new boolean[n][n];

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.add(new Tuple(0, 0, grid[0][0]));

        while( !pq.isEmpty() ) {
            Tuple tt = pq.poll();

            if(visited[tt.x][tt.y]) continue;
            visited[tt.x][tt.y] = true;
            res = Math.max(res, tt.w);
            if(tt.x == n-1 && tt.y == n-1) return res;

            int dr[]={0, 0, -1, 1};
            int dc[]={1, -1, 0, 0};

            for(int i = 0; i<4; i++) {
                int xx = dr[i] + tt.x, yy = dc[i] + tt.y;
                if(xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
                pq.add(new Tuple(xx, yy, grid[xx][yy]));
            }

        }
        return res;
    }
}