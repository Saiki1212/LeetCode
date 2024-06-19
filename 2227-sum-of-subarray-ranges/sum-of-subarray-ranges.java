class Solution {

    public static int FindMaxMin(int[] nums, int i, int j, boolean isMax) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(; i<=j; i++) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
        }
        if(isMax) return max;
        return min;
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        long res = 0;
        for(int i=1; i<n; i++) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            int j = 0;
            for(; j<=i; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
            }
            int diff = max-min;
            res += diff;
            for(; j<n; j++) {
                if(nums[j-i-1] == max) max = FindMaxMin(nums, (j-i), j, true);
                else if(nums[j-i-1] == min) min = FindMaxMin(nums, (j-i), j, false);
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                diff = max-min;
                res += diff;
            }
        }
        return res;
    }
}