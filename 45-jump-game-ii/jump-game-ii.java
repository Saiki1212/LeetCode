class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for(int i=0; i<n; i++) {
            int idx = i+nums[i];
            if(idx >= n) idx = n-1;
            for(int j = idx; j>=(i+1); j--) {
                if(dp[n-1] != n) return dp[n-1];
                dp[j] = Math.min(dp[i]+1, dp[j]);
            }
            // System.out.println(dp[i]);
        }
        return dp[n-1];
    }
}