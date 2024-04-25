class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb=new StringBuilder();
        
        for(int i = 0; i<n;) {
            i = checkSubString(i, s, n, sb);
        }
        return sb.toString();
    }

    public static int checkSubString(int i, String s, int n, StringBuilder sb) {
        int cnt = 1, idx = i+1;

        while(cnt > 0 && idx < n) {
            if(s.charAt(idx) == '(') cnt++;
            else cnt--;
            idx++;
        }
        sb.append(s.substring(i+1, idx-1));
        return idx;
    }
}