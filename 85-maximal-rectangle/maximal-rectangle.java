class Solution {
    public int maximalRectangle(char[][] mat) {
        int maxi = 0, row = mat.length, col = mat[0].length;
        int nums[] = new int[col];

        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                if(mat[i][j] == '1') nums[j]++;
                else nums[j] = 0; 
            }
            maxi = Math.max(maxi, largestRectangleArea(nums));
        }
        return maxi;
    }
    public static int largestRectangleArea(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        int maxi = 0;

        for(int i=0; i<=n; i++) {
            while(!st.isEmpty() && (i==n || nums[st.peek()] >= nums[i])) {
                int preHeight = nums[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()) width = i;
                else width = i - st.peek()-1;
                maxi = Math.max(maxi, width * preHeight);
            }
            st.push(i);
        }
        return maxi;
    }
}