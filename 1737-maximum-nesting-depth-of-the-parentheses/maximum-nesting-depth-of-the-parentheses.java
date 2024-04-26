class Solution {
    public int maxDepth(String s) {
        int n = s.length();

        int cnt = 0, maxi = 0;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                cnt++;
                maxi = Math.max(maxi, cnt);
            }
            else if(c == ')') cnt--;
        }
        return maxi;
    }
}