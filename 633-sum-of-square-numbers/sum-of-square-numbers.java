class Solution {
    public boolean judgeSquareSum(int c) {
        long s = 0, e = (long)Math.sqrt(c);

        while(s<=e) {
            long x = s*s, y = e*e;
            if(x+y == c) return true;
            if(x+y < c) s++;
            else e--;
        }
        return false;
    }
}