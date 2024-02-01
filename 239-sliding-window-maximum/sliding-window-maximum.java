class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque <Integer> qq = new ArrayDeque<>();
        int n = nums.length;
        int []res = new int [n-k+1];

        for(int i=0; i<k; i++) {
            while(!qq.isEmpty() && nums[i] >= nums[qq.peekLast()])
                qq.removeLast();
            qq.addLast(i);
        }
        int idx = 0;
        for(int i=k; i<n; i++) {

            res[idx++] = nums[qq.peek()];
            if( !qq.isEmpty() && qq.peek() <= i-k)
                qq.poll();
            while( !qq.isEmpty() && nums[i] >= nums[qq.peekLast()])
                qq.pollLast();
            qq.offer(i);
            
        }

        res[idx] = nums[qq.peek()];
        return res;
    }
}