class Solution {
    public int findMin(int[] nums) {
        int s = 0, e = nums.length-1, mini = Integer.MAX_VALUE;

        while(s <= e) {
            int m = (s+e)/2;
            mini = Math.min(mini, nums[m]);
            if(nums[m] >= nums[s]) {
                mini = Math.min(mini, nums[s]);
                s = m+1;
            }
            else {
                e = m-1;
            }
        }
        return mini;
    }
}