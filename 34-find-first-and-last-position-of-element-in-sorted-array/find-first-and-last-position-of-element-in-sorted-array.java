class Solution {
    public int[] searchRange(int[] nums, int tar) {
        int res[] = new int[2];
        res[0] = -1; res[1] = -1;
        int n = nums.length;
        if(n == 0) return res;
        int s = 0, e = n-1;

        while(s <= e) {
            int m = (s+e)/2;
            if(nums[m] < tar) s = m+1;
            else e = m-1;
        }
        if(s == n || nums[s] != tar) return res;
        if(nums[s] == tar) res[0] = s;

        s = 0; e = nums.length-1;
        while(s <= e) {
            int m = (s+e)/2;
            if(nums[m] <= tar) s = m+1;
            else e = m-1;
        }
        res[1] = e;
        return res;
    }
}