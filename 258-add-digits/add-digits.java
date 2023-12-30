class Solution {
    public int addDigits(int n) {
        if(n >= 0 && n <=9) return n;
        int ans = 0;
        while(n > 9) {
            int sum = 0;
            while(n > 0) {
                sum += n % 10;
                n = n/10;
            }
            n = sum;
            ans = sum;
        }
        return ans;
    }
}