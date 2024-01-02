class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(c == '*')
                stack.pop();
            else
                stack.push(c);
        }
        String result = "";
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        StringBuilder ans = new StringBuilder(result);
        ans.reverse();
        return ans.toString();
    }
}