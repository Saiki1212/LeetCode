class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int row = mat.length , col = mat[0].length;
        List<Integer> list = new ArrayList<>();
        int sr = 0, sc = 0;
        while(sr < row && sc < col) {
            for(int i = sc; i<col; i++)
                list.add(mat[sr][i]);
            sr++;
            for(int i = sr; i<row; i++) 
                list.add(mat[i][col-1]);
            col--;
            if(sr < row) {
                for(int i = col-1; i>=sc; i--)
                    list.add(mat[row-1][i]);
                row--;
            }

            if(sc < col) {
                for(int i = row-1; i >= sr; i--)
                    list.add(mat[i][sc]);
                sc++;
            }  
        }
        return list;
    }
}