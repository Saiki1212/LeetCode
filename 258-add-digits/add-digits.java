class Solution {
    public int addDigits(int n) {
        if(n >= 0 && n <=9) return n;
        else if(n % 9 == 0) return 9;
        else return n % 9;
    }
}