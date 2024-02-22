class Solution {

    public static int findH(int [] nums, int m ,int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += Math.ceil((double)(nums[i]) / (double)(m));
        }
        return count;
    }

    public int minEatingSpeed(int[] nums, int h) {
        int n = nums.length, e = 0;
        for(int i = 0; i<n; i++) e = Math.max(e, nums[i]);
        int s = 1;
        while(s <= e) {
            int m = (s+e)/2;
            int hours = findH(nums, m, n);
            if(hours > h) s = m+1;
            else e = m-1;
        }
        return s;
    }
}