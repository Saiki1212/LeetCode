class Solution {
    static int doMod = (int)Math.pow(10, 9) + 7;
    public int numRollsToTarget(int n, int k, int target) {
        if (n == 0 && target == 0) 
            return 1;
        if (target < n || n * k < target) 
            return 0;
       int [][] dp = new int[n+1][target+1];
    //    for(int[] d : dp) Arrays.fill(d, -1);
       return FindPath(n, k, target, dp);
    }
    public static int FindPath(int n, int k, int target, int[][] dp) {
        if(n == 0 && target == 0) return 1;

        if (target < n || n * k < target) {
            return 0;
        }

        if(dp[n][target] != 0) return dp[n][target];
        int ways = 0;
        for(int i=1; i<=k; i++) {
            if(target < i) break;
            ways = (ways + FindPath(n-1, k, target-i, dp) % doMod) % doMod;
        }
        return dp[n][target] = ways;
    }
}