class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int count = 1;
        String res = "";
        for(int i=1; i<n; i++) {
            char c=s.charAt(i);
            if(c == '(') count++;
            else count--;
            if(count == 0) {i++; count++;}
            else res += c;
        }
        return res;
    }
}