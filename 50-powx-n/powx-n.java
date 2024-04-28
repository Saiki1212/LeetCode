class Solution {

    public static double GetPow(double x, long nn, double pow) {
        if(nn <= 0) return 1.0;
        if(nn == 1) return pow * x;
        if(nn % 2 != 0) pow = pow * x;
        x = x * x;
        nn = nn/2;
        return GetPow(x, nn, pow);
    }

    public double myPow(double x, int n) {
        if(x == 0) return 0;

        boolean sign = false;
        long nn = n;
        if(n < 0) {
            nn = -1 * nn;
            sign = true;
        }
        double val = GetPow(x, nn, 1.0);
        return sign == true ? (1.0)/val : val;
    }
}