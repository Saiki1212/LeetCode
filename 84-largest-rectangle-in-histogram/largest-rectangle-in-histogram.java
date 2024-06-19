class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int left [] = new int[n];
        int right [] = new int[n];


        Stack<Integer> st = new Stack<>();

        // left min and right min
        for(int i = 0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            if(st.isEmpty()) left[i] = i;
            else left[i] = i-st.peek()-1;
            st.push(i);
        }

        st.clear();

        for(int i = n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            if(st.isEmpty()) right[i] = n-i;
            else right[i] = st.peek()-i;
            st.push(i);
        }
        int max = 0;
        for(int i=0; i<n; i++){

            int diff = right[i]+left[i];

            int a = diff*nums[i];

            max = Math.max(max, a);
            // System.out.println(a + " -- " + max);
            // System.out.println(" left[i] == " + left[i] + "  --  right[i] == " + right[i]);
        }
        return max;
    }
}