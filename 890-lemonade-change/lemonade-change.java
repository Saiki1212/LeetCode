class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int d5 = 0, d10 = 0;
        for(int i=0; i<n; i++) {
            if(bills[i] == 5) d5++;
            else if(bills[i] == 10) {
                if(d5 <= 0) return false;
                d5--;
                d10++;
            }
            else {
                if(d5 <= 0) return false;
                if(d10 <= 0) {
                    if(d5 <= 2) return false;
                    d5 -= 3;
                }
                else {
                    d10--;
                    d5--;
                }
            }
        }
        return true;
    }
}