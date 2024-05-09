class Solution {
    public long maximumHappinessSum(int[] nums, int k) {
        int n  = nums.length;
        Arrays.sort(nums);
        long sum = 0;
        int i = n-1, minus = 0;
        while( k > 0 ) {
            nums[i] = Math.max(nums[i]-minus, 0);
            sum += nums[i--];
            minus++;
            k--;
        }
        return sum;
    }
}