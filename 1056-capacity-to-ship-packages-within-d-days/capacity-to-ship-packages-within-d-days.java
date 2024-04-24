class Solution {
    
    public static boolean fun(int[] nums, int mid, int days) {
        int cnt = 0;
        for(int i : nums) {
            cnt += i;
            if(cnt > mid) {
                days--;
                cnt = i;
            }
        }
        days--;
        return ( days >= 0 );
    }

    public int shipWithinDays(int[] nums, int days) {
        int n = nums.length, s = 0, e = 100000000;
        for(int i : nums) s = Math.max(i, s);

        while( s<= e) {
            int m = (s+e)/2;
            if(fun(nums, m, days)) e = m-1;
            else s = m+1;
        }
        return s;

    }
}