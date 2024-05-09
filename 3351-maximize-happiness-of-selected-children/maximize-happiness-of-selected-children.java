class Solution {
    public long maximumHappinessSum(int[] nums, int k) {
        int n  = nums.length;
        Arrays.sort(nums);
        long sum = 0;

        int minus = 0;

        for(int i=n-1; i>=0; i--) {
            if(k == 0) return sum;
            int val = nums[i] - minus;
            if(val > 0) sum += val;
            minus++;
            k--;
        }
        return sum;
    }
}