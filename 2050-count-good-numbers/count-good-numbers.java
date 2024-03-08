class Solution {
    static int mod = 1000000007;

    public static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        } else {
            long half = pow(a, b / 2) % mod;
            long result = (half * half) % mod;

            if (b % 2 == 1) {
                result = (result * a) % mod;
            }

            return result;
        }
    }

    public int countGoodNumbers(long n) {
        long evenPlaces = (n+1)/2;
        long primePlaces = (n)/2;
        long x = pow(5, evenPlaces) % mod;
        long y = pow(4, primePlaces) % mod;
        // System.out.println("x "+x+" y "+y);
        long ans = (x * y) % mod;
        System.out.println(ans);
        return (int) ans;
    }
}