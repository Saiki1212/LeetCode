class Solution {
    public int firstUniqChar(String s) {
        int ans = Integer.MAX_VALUE;
        for(char c = 'a' ; c <= 'z' ; c++) {
            int idx = s.indexOf(c);
            if(idx != -1 && idx == s.lastIndexOf(c))
                ans = Math.min(idx, ans);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}