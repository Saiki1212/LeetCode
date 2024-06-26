class Solution {

    public static void makeOtoA(char [][] mat, int i, int j, int r, int c) {
        if(i<0 || j<0 || i>=r || j>=c || mat[i][j] != 'O') return;
        mat[i][j] = 'A';

        makeOtoA(mat, i-1, j, r, c);
        makeOtoA(mat, i+1, j, r, c);
        makeOtoA(mat, i, j-1, r, c);
        makeOtoA(mat, i, j+1, r, c);
    }

    public void solve(char[][] mat) {
        int r = mat.length, c = mat[0].length;

        for(int i=0; i<r; i++) {
            if(mat[i][0] == 'O') makeOtoA(mat, i, 0, r, c);
            if(mat[i][c-1] == 'O') makeOtoA(mat, i, c-1, r, c);
        }

        for(int i=0; i<c; i++) {
            if(mat[0][i] == 'O') makeOtoA(mat, 0, i, r, c);
            if(mat[r-1][i] == 'O') makeOtoA(mat, r-1, i, r, c);
        }

        for(int i=0; i<r; i++) {
            for(int j = 0; j<c; j++) {
                if(mat[i][j] == 'A') mat[i][j] = 'O';
                else if(mat[i][j] == 'O') mat[i][j] = 'X';
            }
        }

        // boolean visited[][] = new boolean[r][c];

        // for(int i=0; i<r; i++) {
        //     for(int j = 0; j<c; j++) {
        //         if(mat[i][j] == 'O' && !visited[i][j]) makeCrosses(mat, visited, i, j, r, c);
        //     }
        // }

    }

    // public static boolean makeCrosses(char [][] mat, boolean visited[][], int i, int j, int r, int c) {
    //     if(i < 0 || j < 0 || i >= r || j >= c) return false;
    //     if(mat[i][j] == 'X') return true;

    //     // System.out.println(i + " - " + j + " - " + mat[i][j]);

    //     mat[i][j] = 'X';
    //     visited[i][j] = true;
    //     boolean top = makeCrosses(mat, visited, i-1, j, r, c) && makeCrosses(mat, visited, i+1, j, r, c) &&
    //                     makeCrosses(mat, visited, i, j-1, r, c) && makeCrosses(mat, visited, i, j+1, r, c);
    //     // System.out.println(top);
    //     if(!top) mat[i][j] = 'O';
    //     return top;
    // }

}

/*


["O","X","X","O","X"],
["X","O","O","X","O"],
["X","O","X","O","X"],
["O","X","O","O","O"],
["X","X","O","X","O"],

["O","X","X","O","X"],
["X","X","X","X","O"],
["X","X","X","O","X"],
["O","X","O","O","O"],
["X","X","O","X","O"],


*/