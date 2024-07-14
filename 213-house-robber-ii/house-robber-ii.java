class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        dp[0] = nums[0];
        if(n>=3) dp[1] = nums[1];
        else if(n == 1) return dp[0];
        else return Math.max(nums[0], nums[1]);

        for(int i = 2; i<n-1; i++) {
            if(i == 2) dp[i] = nums[i] + dp[0];
            else dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
        }

        int start = Math.max(dp[n-2], dp[n-3]);

        Arrays.fill(dp, 0);

        
        if(n>=3) {
            dp[1] = nums[1];
            dp[2] = nums[2];
        }
        else if(n == 1) return dp[0];
        else return Math.max(nums[0], nums[1]);

        for(int i = 3; i<n; i++) {
            if(i == 3) dp[i] = nums[i] + dp[1];
            else dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
        }

        return Math.max(start, Math.max(dp[n-1], dp[n-2]));

    }
}