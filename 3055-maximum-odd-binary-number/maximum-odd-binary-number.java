class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int zero = 0, one = 0;
        for(int i =0; i<n; i++) {
            if(s.charAt(i) == '1') one++;
            else zero++;
        }
        String res = "";
        for(int i=1; i<one; i++) 
            res += "1";
        for(int i=1; i<=zero; i++)
            res += "0";
        if(one >=1) res += "1";
        return res;
    }
}