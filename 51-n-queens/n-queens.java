class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();

        char [][] board = new char[n][n];

        for(int i=0 ; i<n; i++) {
            for(int j=0; j<n; j++)
                board[i][j] = '.';
        }

        Solve(list, board, n, 0);
        return list;
    }

    public static void Solve(List<List<String>> list, char [][] board, int n, int c) {
        if(c == n) {
            List<String> temp = new ArrayList<>();
            for(char i[] : board) temp.add(new String(i));
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<n; i++) {
            if(isSafe(board, i, c, n)) {
                board[i][c] = 'Q';
                Solve(list, board, n, c+1);
                board[i][c] = '.';
            }
        }
    }

    public static boolean isSafe(char [][] board, int r, int c, int n) {
        int col = c, row = r;

        while(col >= 0 && row >= 0) {
            if(board[row--][col--] == 'Q') return false;
        }
        col = c; row = r;

        while(row < n && col >= 0) {
            if(board[row++][col--] == 'Q') return false;
        }

        while(c >= 0) {
            if(board[r][c--] == 'Q') return false;
        }
        return true;
    }

}