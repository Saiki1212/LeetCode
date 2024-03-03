class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int s = 0, e = n-1;
        for(int i=n-1; i>=0; i--) {
            if(Math.abs(nums[s]) > nums[e]) {
                res[i] = nums[s]*nums[s++];
            }
            else res[i] = nums[e]*nums[e--];
        }
        return res;
    }
}