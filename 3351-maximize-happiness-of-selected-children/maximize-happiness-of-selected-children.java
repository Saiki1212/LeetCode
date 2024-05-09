class Solution {
    public long maximumHappinessSum(int[] nums, int k) {
        int n  = nums.length;
        Arrays.sort(nums);
        long sum = 0;
        int i = n-1, minus = 0;
        while( k-- > 0 ) {
            if(nums[i] > minus) nums[i] = nums[i]-minus++;
            else break;
            sum += nums[i--];
        }
        return sum;
    }
}