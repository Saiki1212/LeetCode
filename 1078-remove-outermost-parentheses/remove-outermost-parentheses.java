class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int count = 1;
        String res = "";
        for(int i=1; i<n-1; i++) {
            if(s.charAt(i) == '(') count++;
            else count--;
            if(count == 0) {i++; count++;}
            else res += s.charAt(i);
        }
        return res;
    }
}