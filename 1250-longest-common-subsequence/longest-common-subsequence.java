class Solution {
    static int [][]dp;
    public int longestCommonSubsequence(String s1, String s2) {
        int i1 = s1.length();
        int i2 = s2.length();
        dp = new int [i1][i2];
        for(int []d : dp)
            Arrays.fill(d, -1);

        return Fi(i1-1, i2-1, s1, s2);
    }
    static int Fi(int i1, int i2, String s1, String s2) {
        if(i1 < 0 || i2 < 0)
            return 0;
        if(dp[i1][i2] != -1)
            return dp[i1][i2];
        if(s1.charAt(i1) == s2.charAt(i2)) {
            return dp[i1][i2] =  1 + Fi(i1-1, i2-1, s1, s2);
        }
        else {
            return dp[i1][i2] =  Math.max(Fi(i1-1, i2, s1, s2), Fi(i1, i2-1, s1, s2));
        }
    }
}