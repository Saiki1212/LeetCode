class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int total = 0;

        for(int i=1; i<n; i++) {
            if(nums[i-1] >= nums[i]) {
                total += nums[i-1] - nums[i] + 1;
                nums[i] = nums[i-1]+1;
            }
        }
        return total;
    }
}