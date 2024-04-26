class Solution {

    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public int myAtoi(String s) {
        int n = s.length();
        int sign = 0;
        String res = ""; long sum = 0; int i=0;
        while(i < n) {
            char c = s.charAt(i);
            if(res.length() == 0 && c == ' ') i++;
            else if(res.length() == 0 && c == '-' && sign == 0) {
                sign = 1;
                res += '-';
                i++;
            }
            else if(res.length() == 0 && c == '+' && sign == 0) { sign = 2; i++; res += '+';}
            else if (isNumber(c)) {
                res += c;
                int ci = c-'0';
                sum = sum*10 + ci;
                if(sum > Integer.MAX_VALUE) break;
                i++;
            }
            else break;
        }
        if (sign == 1) {
            if (-sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        } else {
            if (sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        if(sign == 1) sum = sum * -1;
        return (int)sum;
    }
}