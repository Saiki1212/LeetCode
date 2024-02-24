class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxi = 1;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for(int i=1; i<n; i++) {
            for(int j = 0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        for(int i : dp) maxi = Math.max(maxi, i);
        return maxi;
    }
}