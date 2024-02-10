class Solution {
    private int count = 0 ;
    public int countSubstrings(String s) {
        int n = s.length();
        for(int i = 0; i<n; i++) {
            isPal(s, i, i);
            isPal(s, i, i+1);
        }
        return count;
    }
    private void isPal(String st, int s, int e) {
        while((s >= 0 && e < st.length()) && st.charAt(s--) == st.charAt(e++)) {
            count++;
        }
    }
}