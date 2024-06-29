class Solution {

    class Pair{
        int x, y, d;
        Pair(int x, int y, int d) {
            this.d = d;
            this.x = x;
            this.y = y;
        }
    }


    public int minimumEffortPath(int[][] grid) {
        int r = grid.length, c = grid[0].length;

        int [][] minHeights = new int[r][c];
        for(int i[] : minHeights) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        minHeights[0][0] = 0;
        PriorityQueue<Pair> dq = new PriorityQueue<>((a, b) -> a.d - b.d);
        dq.add(new Pair(0, 0, 0));
        // grid[0][0] = 0;

        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};

        while( !dq.isEmpty() ) {
            Pair p = dq.remove();
            if(p.x == r-1 && p.y == c-1) return p.d;
            for(int i = 0; i<4; i++) {
                int x = p.x + drow[i], y = p.y + dcol[i];

                if(x < 0 || y < 0 || x >= r || y >= c) continue;

                int newEffort = Math.max(p.d, Math.abs(grid[x][y] - grid[p.x][p.y]));

                if(newEffort >= minHeights[x][y]) continue;

                minHeights[x][y] = newEffort;

                dq.add(new Pair(x, y, newEffort));
            }
        }
        return 0;
    }
}