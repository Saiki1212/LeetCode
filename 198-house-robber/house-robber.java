class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        int [] dp = new int[n];
        dp[0] = nums[0];
        if(n>=2) dp[1] = nums[1];
        else return dp[0];

        for(int i = 2; i<n; i++) {
            if(i == 2) dp[i] = nums[i] + dp[0];
            else dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
        }

        return Math.max(dp[n-1], dp[n-2]);
    }
}