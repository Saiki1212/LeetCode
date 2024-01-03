class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int i=0, j=n-1;
        int sum = 0;
        while(i < n && j >=0) {
            if( i == j && n % 2 != 0) {
                sum += mat[i++][j--];
                continue;
            }
            sum += mat[i][i] + mat[i][j];
            i++; j--;
        }
        return sum;
    }
}

/*
        [7, 3, 1, 9],
        [3, 4, 6, 9],
        [6, 9, 6, 6],
        [9, 5, 8, 5]]
 */