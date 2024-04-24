class Solution {
    public int findKthPositive(int[] nums, int k) {
        int n = nums.length;
        int s = 0, e = n-1;

        while( s<=e ) {
            int m = (s+e)/2;
            if((nums[m] - m - 1) < k) s = m+1;
            else e = m-1;
        }
        return e+k+1;
    }
}