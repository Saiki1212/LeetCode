class Solution {
    int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int getMaximumGold(int[][] g) {
        int res = 0;
        int n = g.length;
        int m = g[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, backTrack(g, i, j, n, m));
            }
        }
        return res;
    }

    public int backTrack(int[][] g, int r, int c, int n, int m) {
        if (!isValid(r, c, n, m) || g[r][c] == 0) return 0;
        int currVal = g[r][c];
        g[r][c] = 0;
        int res = currVal;
        int nextRes = 0;
        for (int i = 0; i < 4; i++) {
            int nextR = r + next[i][0];
            int nextC = c + next[i][1];
            nextRes = Math.max(backTrack(g, nextR, nextC, n, m), nextRes);
        }
        g[r][c] = currVal;
        return res + nextRes;
    }

    public boolean isValid(int r, int c, int n, int m) {
        return (r >= 0 && c >= 0 && r < n && c < m);
    }
}