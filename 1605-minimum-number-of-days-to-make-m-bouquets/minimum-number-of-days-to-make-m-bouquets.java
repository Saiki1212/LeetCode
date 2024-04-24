class Solution {

    public static boolean isTrue(int boq, int[] nums, int mid, int days) {
        int len = nums.length, count = 0;
        for(int i = 0; i<len; i++) {
            if(nums[i] <= mid) count++;
            else {
                int t = (count/days);
                if(t >= 1) {
                    boq = boq - t;
                }
                count = 0;
            }
        }
        int t = (count/days);
        if(t >= 1) {
            boq = boq - t;
        }
        if(boq <= 0) return true;
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long a = (long)m*k;
        if(a > n) return -1;
        int s = Integer.MAX_VALUE, e = 0;
        for(int i : bloomDay) {
            s = Math.min(s, i);
            e = Math.max(e, i);
        }

        while( s <= e ){
            int mid = (s+e)/2;
            // System.out.println(mid);
            if(isTrue(m, bloomDay, mid, k)) e = mid-1;
            else s = mid+1;
        }
        return s;
    }
}