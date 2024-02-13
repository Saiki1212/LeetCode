class Solution {
    public static boolean isPal(String st) {
        int s = 0, e = st.length()-1;
        while(s < e) {
            if(st.charAt(s) != st.charAt(e)) return false;
            s++; e--;
        }
        return true;
    }

    public String firstPalindrome(String[] words) {
        int n = words.length;
        for(int i=0; i<n; i++) {
            if(isPal(words[i])) return words[i];
        }
        return "";
    }
}