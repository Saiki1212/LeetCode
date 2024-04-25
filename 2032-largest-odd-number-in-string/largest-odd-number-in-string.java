class Solution {

    public static boolean isOdd(char c) {
        return c == '1' || c == '3' || c == '5' || c == '7' || c == '9';
    }

    public String largestOddNumber(String s) {
        int n = s.length();
        if(isOdd(s.charAt(n-1))) return s;
        StringBuilder sb = new StringBuilder();

        n -= 2;
        while( n >= 0 && !isOdd(s.charAt(n))) n--;
        sb.append(s.substring(0, n+1));
        return sb.toString();
    }
}