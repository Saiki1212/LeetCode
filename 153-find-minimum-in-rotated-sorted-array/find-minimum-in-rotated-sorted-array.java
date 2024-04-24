class Solution {
    public int findMin(int[] nums) {
        int s = 0, e = nums.length-1;
        int res = Integer.MAX_VALUE;

        while( s<=e ) {
            int m = (s+e)/2;
            if(nums[m] >= nums[s]) {
                res = Math.min(res, nums[s]);
                s = m+1;
            }
            else {
                res = Math.min(res, nums[m]);
                e = m-1;
            }
        }
        return res;
    }
}