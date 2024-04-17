class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for(int i=0; i<n; i++) {
            if(nums[i] < min) min = nums[i];
            else profit = Math.max(profit, nums[i]-min);
        }
        return profit;

    }
}