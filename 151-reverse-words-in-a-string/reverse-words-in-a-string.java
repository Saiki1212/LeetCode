class Solution {
    public String reverseWords(String str) {
        String s = str.trim();
        int n = s.length();
        int i = n-1;
        StringBuilder sb = new StringBuilder();
        int j = n-1;

        while(i >= 0) {
            if(s.charAt(i) == ' ') {
                sb.append(s.substring(i+1,j+1));
                sb.append(" ");
                while(s.charAt(i) == ' ') i--;
                j = i;
            }
            i--;
        }
        sb.append(s.substring(i+1, j+1));
        return sb.toString();
    }
}