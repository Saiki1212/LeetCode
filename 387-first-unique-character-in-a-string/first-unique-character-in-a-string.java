class Solution {
    public int firstUniqChar(String s) {
        int ans = Integer.MAX_VALUE;
        char st[] = s.toCharArray();
        for(char c : st) {
            int idx = s.indexOf(c);
            if(idx != -1 && idx == s.lastIndexOf(c))
                ans = Math.min(idx, ans);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}