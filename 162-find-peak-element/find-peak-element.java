class Solution {
    public int findPeakElement(int[] nums) {
        int maxi = Integer.MIN_VALUE, n=nums.length;
        int idx = 0;
        for(int i = 0; i<n; i++) {
            if(maxi < nums[i]) {
                maxi = nums[i];
                idx = i;
            }
        }
        return idx;
    }
}