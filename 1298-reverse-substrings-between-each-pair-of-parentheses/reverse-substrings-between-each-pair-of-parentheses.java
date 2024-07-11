class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        boolean isBracket = false;
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '(') {
                isBracket = true;
                break;
            }
        }
        if(!isBracket) return s;

        Stack<String> st = new Stack<>();
        int i = 0;
        while(i < n) {
            if(s.charAt(i) == '(') {
                st.push("(");
                i++;

                String temp = "";
                while(s.charAt(i) != ')' && s.charAt(i) != '(') {
                    temp += s.charAt(i++);
                }
                st.push(temp);
            }
            else if(s.charAt(i) != ')') {
                String temp = "";
                while(i<n && s.charAt(i) != ')' && s.charAt(i) != '(') {
                    temp += s.charAt(i++);
                }
                st.push(temp);
            }

            if(i<n && s.charAt(i) == ')') {
                String temp = "";
                while(!st.isEmpty() && !st.peek().equals("(")) {
                    temp = st.pop() + temp;
                }
                if(!st.isEmpty()) st.pop();
                st.push(reverseStr(temp));
                i++;
            }
        }
        String str = "";
        while(!st.isEmpty())
            str = st.pop() + str;
        return str;
    }
    public String reverseStr(String temp) {
        String a = "";
        int n = temp.length();
        for(int i = 0; i<n; i++) {
            a = temp.charAt(i) + a;
        }
        // System.out.println(a);
        return a;
    }
}