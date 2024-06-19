class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque < Integer > dq = new ArrayDeque<>();

        for(int i=0; i<k; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();
            dq.addLast(i);
        }
        int idx = 0;
        int result[] = new int[n-k+1];
        for(int i=k; i<n; i++) {
            result[idx++] = nums[dq.peek()];
            if(!dq.isEmpty() && dq.peek() <= i-k) dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();
            dq.addLast(i);
        }
        result[idx++] = nums[dq.peek()];
        return result;
    }
}