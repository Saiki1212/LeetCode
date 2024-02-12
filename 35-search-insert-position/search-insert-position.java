class Solution {
    public int searchInsert(int[] nums, int tar) {
        int s = 0, e = nums.length-1, idx = e+1;

        while(s<=e) {
            int m = (s+e)/2;
            if(nums[m] == tar) return m;
            if(nums[m] >= tar) {
                idx = m;
                e = m-1;
            }
            else s = m+1;
        }
        return idx;
    }
}