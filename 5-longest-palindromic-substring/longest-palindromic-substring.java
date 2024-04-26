class Solution {

    public static boolean isPal(String s) {
        int i=0, n = s.length()-1;
        while(i < n) {
            if(s.charAt(i) != s.charAt(n)) return false;
            n--;
            i++;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        String []str = {""};

        for(int i=0; i<n; i++) {
            for(int j = n-1; j>=i; j--) {
                if(isPal(s.substring(i, j+1)) && str[0].length() < (j-i+1)) {
                    str[0] = s.substring(i, j+1);
                    break;
                }
            }
        }
        return str[0];
    }
}