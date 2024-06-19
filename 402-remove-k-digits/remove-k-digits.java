class Solution {
    public String removeKdigits(String s, int k) {
        int n = s.length();
        if(n <= k) return "0";
        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++) {
            // if(k == 0) break;
            char c = s.charAt(i);
            while(!st.isEmpty() && st.peek() > c && k-- > 0) st.pop();
            if(c == '0' && st.isEmpty()) continue;
            st.push(c);
        }
        String str = "";
        while(!st.isEmpty()) {
            k--;
            if(k >= 0) { st.pop(); continue;}
            str = st.pop() + str;
        }
        return str.length() == 0 ? "0" : str;
    }
}