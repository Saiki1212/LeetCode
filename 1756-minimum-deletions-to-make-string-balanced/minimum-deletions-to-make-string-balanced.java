class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int noOfDeletions = 0;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<n; i++) {
            char c = s.charAt(i);
            if(stack.isEmpty() || c == 'b') stack.push(c);
            else if(stack.peek() == 'b'){
                stack.pop();
                noOfDeletions++;
            }
        }
        return noOfDeletions;
    }
}