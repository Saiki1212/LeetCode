class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int i = n-1;
        StringBuilder sb = new StringBuilder();
        int j = n-1;

        if(s.charAt(i) == ' ') {
            while(s.charAt(i) == ' ') i--;
            j = i;
        }

        while(i >= 0) {
            if(s.charAt(i) == ' ') {
                sb.append(s.substring(i+1,j+1));
                sb.append(" ");
                while( i>=0 && s.charAt(i) == ' ') i--;
                if(i < 0) return sb.deleteCharAt(sb.length()-1).toString();
                j = i;
            }
            i--;
        }

        sb.append(s.substring(i+1, j+1));
        return sb.toString();
    }
}