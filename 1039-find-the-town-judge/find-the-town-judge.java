class Solution {
    public int findJudge(int n, int[][] trust) {
        int first[] = new int[n+1];
        int second[] = new int[n+1];

        for(int []a : trust) {
            first[a[0]]++;
            second[a[1]]++;
        }

        for(int i=1; i<=n; i++) {
            if(first[i] == 0 && second[i] == n-1) return i;
        }
        return -1;
    }
}