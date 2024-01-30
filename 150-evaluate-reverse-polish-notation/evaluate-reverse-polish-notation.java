class Solution {
    public static boolean isSymbol(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    public static int Val(int b, int a, String c) {
        if(c.equals("+")) return (a+b);
        else if(c.equals("-")) return (a-b);
        else if(c.equals("*")) return (a*b);
        else return (a / b);
    }


    public int evalRPN(String[] tokens) {
        Stack <Integer> stack = new Stack<>();
        int n = tokens.length;

        for(int i=0; i<n; i++) {
            if(isSymbol(tokens[i])) {
                int top1 = stack.pop();
                int top2 = stack.pop();
                stack.add(Val(top1, top2, tokens[i]));
            }
            else {
                stack.add(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}