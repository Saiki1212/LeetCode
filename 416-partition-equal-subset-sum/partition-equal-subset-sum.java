class Solution {
    private int [][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int tot = 0;
        for(int i : nums) tot += i;

        if(tot % 2 != 0) return false;

        tot /= 2;
        dp = new int[201][tot + 1];
        for(int i[] : dp) Arrays.fill(i, -1);

        return fun(nums, tot, n-1);
    }

    public boolean fun(int[] nums, int sum, int i) {
        if(sum == 0) return true;
        if(i == 0) return sum == nums[0];

        if(dp[i][sum] != -1) return dp[i][sum] == 0 ? false : true;

        boolean take = false;

        if(sum >= nums[i]) take = fun(nums, sum-nums[i], i-1);
        boolean notTake = fun(nums, sum, i-1);

        dp[i][sum] = (take || notTake) ? 1 : 0;
        return (take || notTake);
    }

}