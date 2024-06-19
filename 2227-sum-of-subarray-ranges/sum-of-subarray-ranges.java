class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;

        for(int i=0; i<n; i++) {
            int min = nums[i];
            int max = nums[i];
            for(int j = i; j<n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += (max-min);
            }
        }
        return res;
    }
}