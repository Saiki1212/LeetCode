class Solution {
    public int maxProfit(int[] nums) {
        int profit = 0;
        int mini = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] < mini)
                mini = nums[i];
            else {
                profit = Math.max(profit, nums[i] - mini);
            }
        }
        return profit;
    }
}