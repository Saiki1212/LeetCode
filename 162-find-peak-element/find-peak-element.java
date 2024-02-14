class Solution {
    public static boolean isPeak(int [] nums, int m) {
        return nums[m] > nums[m-1] && nums[m] > nums[m+1];
    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1 || nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;
        int s = 1, e = n-2;

        while(s <= e) {
            int m = (s+e)/2;
            if(isPeak(nums, m)) return m;
            if(nums[m] > nums[m-1]) s = m+1;
            else e = m-1;
        }
        return -1;
    }
}