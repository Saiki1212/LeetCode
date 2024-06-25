class Solution {
    class Pair{
        int x,y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void bfs(int[][] mat, int r, int c, Deque<Pair> dq, boolean [][] visited) {

        int[] newRow = {-1, 0, 0, 1};
        int[] newCol = {0, -1, 1, 0};
        int dist = 0;

        while( !dq.isEmpty() ) {
            int n = dq.size();
            dist++;
            for(int k = 0; k<n; k++) {
                Pair pair = dq.pollFirst();
                int x = pair.x, y = pair.y;

                for(int a = 0; a<4; a++) {
                    int xx = x + newRow[a], yy = y + newCol[a];

                    if(xx < 0 || xx >= r || yy <0 || yy >= c || mat[xx][yy] == 0 || visited[xx][yy]) continue;
                    if(mat[xx][yy] == 1) mat[xx][yy] = dist;
                    else continue;
                    visited[xx][yy] = true;
                    dq.add(new Pair(xx, yy));
                }
            }
        }

    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        Deque<Pair> dq = new ArrayDeque<>();
        boolean [][] visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(mat[i][j] == 0) {
                    dq.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        bfs(mat, m, n, dq, visited);
        return mat;
    }
}