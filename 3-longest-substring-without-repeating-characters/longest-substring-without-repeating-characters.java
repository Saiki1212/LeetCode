class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int maxLen = 0, len = 0;

        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            String str = String.valueOf(c);
            int idx = sb.indexOf(str);
            if(idx != -1) {
                int j = 0;
                while(j <= idx) {
                    sb.deleteCharAt(0);
                    j++;
                    len--;
                }
            }
            sb.append(c);
            len++;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}