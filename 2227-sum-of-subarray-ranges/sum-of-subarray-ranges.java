class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        // sub array minimuns....
        int [] key1 = new int[n];
        int [] key2 = new int[n];

        long subArrayMinimums = FindMinimum(st, key1, key2, n, nums);
        Arrays.fill(key1, 0);
        Arrays.fill(key2, 0);
        st.clear();
        long subArrayMaximums = FindMaximum(st, key1, key2, n, nums);
        return subArrayMaximums - subArrayMinimums;

    }

    public static long FindMinimum(Stack<Integer> st, int [] key1, int [] key2, int n, int[] nums) {
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if(st.isEmpty()) key2[i] = n-i;
            else key2[i] = st.peek()-i;
            st.push(i);
        }

        st.clear();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            if(st.isEmpty()) key1[i] = i+1;
            else  key1[i] = i-st.peek();
            st.push(i);
        }

        long t = 0;
        for(int i=0; i<n; i++) {
            long c = key1[i] * key2[i] ;
            t = t + nums[i]*c;
        }
        return t;
    }

    public static long FindMaximum(Stack<Integer> st, int [] key1, int [] key2, int n, int[] nums) {
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            if(st.isEmpty()) key2[i] = n-i;
            else key2[i] = st.peek()-i;
            st.push(i);
        }

        st.clear();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            if(st.isEmpty()) key1[i] = i+1;
            else  key1[i] = i-st.peek();
            st.push(i);
        }

        long t = 0;
        for(int i=0; i<n; i++) {
            long c = key1[i] * key2[i] ;
            t = t + nums[i]*c ;
        }
        return t;
    }
}