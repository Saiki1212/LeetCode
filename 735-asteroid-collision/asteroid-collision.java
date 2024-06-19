class Solution {
    public int[] asteroidCollision(int[] ast) {
        int n = ast.length;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            boolean sign = ast[i] < 0 ? true : false;
            boolean flag = false;
            int val = Math.abs(ast[i]);
            if(!st.isEmpty() && ast[st.peek()] >=0 && !sign) st.push(i);
            else if(!st.isEmpty() && ast[st.peek()] < 0 && sign) st.push(i);
            else {
                while(!st.isEmpty() && ast[st.peek()] >=0) {
                    if(val == ast[st.peek()]) {
                        flag = true;
                        st.pop();
                        break;
                    }
                    if(val < ast[st.peek()]) {
                        flag = true;
                        break;
                    }
                    else st.pop();
                }
                if(!flag) st.push(i);
            }
        }

        n = st.size();
        int res[] = new int[n];
        for(int i=n-1; i>=0; i--) {
            res[i] = ast[st.pop()];
        }

        return res;
    }
}