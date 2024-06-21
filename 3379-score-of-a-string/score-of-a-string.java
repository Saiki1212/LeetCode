class Solution {
    public int scoreOfString(String s) {
        int n = s.length();

        int count = 0;

        for(int i = 1; i<n; i++) {
            count +=  Math.abs(s.charAt(i-1) - s.charAt(i));
        }
        return count;
    }
}