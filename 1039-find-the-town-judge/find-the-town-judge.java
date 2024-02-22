class Solution {
    public int findJudge(int n, int[][] trust) {
        int r = trust.length;
        if(r == 0 && n==1) return 1;
        int first[] = new int[n+1];
        int ans = 0;
        for(int []a : trust) {
            first[a[1]]++;
            if(first[a[1]] == n-1) ans = a[1];
        }
        if(ans  == 0) return -1;

        for(int []a : trust) {
            if(a[0] == ans) return -1;
        }
        return ans;
    }
}