class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        for(int i=0; i<n; i++) {
            if(maxi < i) return false;
            else maxi = Math.max(maxi, nums[i] + i);

            if(maxi >= n-1) return true;
        }
        return true;
    }
}