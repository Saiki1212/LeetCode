class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int sum1 = 0;
        for(int i=0; i<n; i++)
            sum1 += s.charAt(i) == '1' ? 1 : 0;
        int sum0 = 0, maxi = 0;
        for(int i=0; i<n-1; i++) {
            char c = s.charAt(i);
            if(c == '0') {
                sum0++;
                maxi = Math.max(maxi, (sum0+sum1));
            }
            else {
                sum1--;
                maxi = Math.max(maxi, (sum0+sum1));
            }
        }
        return maxi;
    }
}