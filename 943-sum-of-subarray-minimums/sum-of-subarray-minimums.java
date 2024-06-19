class Solution {
    public int sumSubarrayMins(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        // Elements smaller than nums[i] in right and left;
        int [] key1 = new int[n];
        int [] key2 = new int[n];

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if(st.isEmpty()) key2[i] = n-i;
            else key2[i] = st.peek()-i;
            // System.out.println("nums[i] ==  " +(nums[i])+ "  --  key2[i] = =  "+key[i]);
            st.push(i);
        }

        st.clear();

        int mod = 1000000007;

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            if(st.isEmpty()) key1[i] = i+1;
            else  key1[i] = i-st.peek();
            // System.out.println("nums[i] ==  " +(nums[i])+ "  --  key1[i] = =  "+key[i]);
            st.push(i);
        }

        long t = 0;
        for(int i=0; i<n; i++) {
            long c = key1[i] * key2[i] % mod;
            t = (t + (nums[i]*c) % mod)%mod;
        }
        return (int)t;
    }
}