class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int profit = 0;
        int mini = nums[0];
        for(int i=1; i<n; i++) {
            if(nums[i] < mini)
                mini = nums[i];
            else {
                profit = Math.max(profit, nums[i] - mini);
            }
        }
        return profit;
    }
}