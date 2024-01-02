class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sol = 0;
        for(int i=0; i<k; i++) {
            sol += nums[i];
        }
        double ans = sol;
        sol = ans;
        for(int i=k; i<n; i++) {
            ans = ans - nums[i-k] + nums[i];
            sol = Math.max(sol, ans);
        }
        return sol/k;
    }
}