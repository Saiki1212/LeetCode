class Solution {

    public static int totalH(int []nums, int m) {
        int c = 0;
        for(int i : nums) {
            c += Math.ceil((double)(i) / (double)(m));
        }
        return c;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int s = 1, e=0;
        for(int i: piles) e = Math.max(i, e);

        while( s<=e ) {
            int m = (s+e)/2;
            int th = totalH(piles, m);
            if(th <= h) e = m-1;
            else s = m+1;
        }
        return s;
    }
}