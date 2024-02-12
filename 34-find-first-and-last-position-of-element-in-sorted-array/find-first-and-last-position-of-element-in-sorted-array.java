class Solution {
    public int[] searchRange(int[] nums, int tar) {
        int n = nums.length-1, low = 0, up = n+1, s = 0, e = n;

        while(s <= e) {
            int m = (s+e)/2;
            if(nums[m] >= tar) {
                low = m;
                e = m-1;
            }
            else s = m+1;
        }
        if(low == n+1 || nums[low] != tar) return new int [] {-1,-1};

        s = 0; e = n;

        while(s <= e) {
            int m = (s+e)/2;
            if(nums[m] > tar) {
                up = m;
                e = m-1;
            }
            else 
                s = m+1;
        }
        return new int[] {low, up-1};
    }
}