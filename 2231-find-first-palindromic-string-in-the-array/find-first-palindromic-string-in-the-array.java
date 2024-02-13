class Solution {
    public static boolean isPal(String s) {
        StringBuilder str = new StringBuilder(s);
        str = str.reverse();
        String st = str.toString();
        return s.equals(st);
    }

    public String firstPalindrome(String[] words) {
        int n = words.length;
        for(int i=0; i<n; i++) {
            if(isPal(words[i])) return words[i];
        }
        return "";
    }
}