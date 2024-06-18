class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int l = 0, r = n-1, lmax = 0, rmax = 0, total = 0;

        while(l < r) {
            if(nums[l] <= nums[r]) {
                if(nums[l] >= lmax) lmax = nums[l];
                else total += lmax-nums[l];
                l++;
            }
            else {
                if(nums[r] >= rmax) rmax = nums[r];
                else total += rmax-nums[r];
                r--;
            }
        }
        return total;
    }
}