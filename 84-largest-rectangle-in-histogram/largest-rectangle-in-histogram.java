class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        int maxi = 0;

        for(int i=0; i<=n; i++) {
            while(!st.isEmpty() && (i==n || nums[st.peek()] >= nums[i])) {
                int he = nums[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()) width = i;
                else width = i - st.peek()-1;
                maxi = Math.max(maxi, width * he);
            }
            st.push(i);
        }
        return maxi;
    }
}