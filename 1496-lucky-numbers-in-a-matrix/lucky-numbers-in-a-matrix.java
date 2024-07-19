class Solution {
    public List<Integer> luckyNumbers (int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<Integer> temp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i<m; i++) {
            int rowMin = 100001;
            for(int j = 0; j<n; j++) {
                rowMin = Math.min(rowMin, mat[i][j]);
            }
            temp.add(rowMin);
        }

        for(int i = 0; i<n; i++) {
            int colMax = 0;
            for(int j = 0; j<m; j++) {
                colMax = Math.max(colMax, mat[j][i]);
            }
            if(temp.contains(colMax)) result.add(colMax);
            else temp.add(colMax);
        }
        return result;
    }
}


// 

    // 1
    // 2
    // 3
    // 4
    // 5
