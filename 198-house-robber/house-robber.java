class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(dp,  nums, n-1);
    }

    public int solve(int[] dp, int nums[], int idx) {
        if(idx < 0) return 0;
        if(dp[idx] != -1) return dp[idx];

        return dp[idx] = Math.max(solve(dp, nums, idx-1), solve(dp, nums, idx-2) + nums[idx]);

    }
}