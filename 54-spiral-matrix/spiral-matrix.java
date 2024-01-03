class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int count = m*n;
        List<Integer> list = new ArrayList<>(count);

        int i=0;
        int startR = 0, startC = 0;
        while(startR < n && startC < m) {
            for(i = startC; i<m; ++i) 
                list.add(mat[startR][i]);
            
            startR++;

            for(i = startR; i<n; ++i)
                list.add(mat[i][m-1]);
            m--;

            if(startR < n) {
                for(i = m-1; i>=startC; --i)
                    list.add(mat[n-1][i]);
                n--;
            }
            if(startC < m) {
                for(i = n-1; i>=startR; --i)
                    list.add(mat[i][startC]);
                startC++;
            }
        }

        return list;
    }
}