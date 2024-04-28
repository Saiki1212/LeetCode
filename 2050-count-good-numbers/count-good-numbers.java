class Solution {

    static int mod = 1000000007;

    public static long GetPow(long val, long n, long pow) {
        if(n <= 0) return 1;
        if(n == 1) return (pow*val) % mod;
        if(n % 2 != 0) pow = (pow * val) % mod;
        n = n/2;
        val = (val*val) % mod;
        return GetPow(val, n, pow);
    }

    public int countGoodNumbers(long n) {
        long toteven = (n+1)/2;
        long totodd = n/2;

        long even = GetPow(5, toteven, 1);
        long odd = GetPow(4, totodd, 1);

        long ans = (even * odd) % mod;
        return (int) ans;
    }
}