class Solution {
    public int search(int[] nums, int tar) {
        int s = 0, e = nums.length-1;
        while(s <= e) {
            int m = (s+e)/2;
            if(nums[m] == tar) return m;
            if(nums[m] >= nums[s]) {
                if(nums[m] > tar && nums[s] <= tar) e = m-1;
                else s = m+1;
            }
            else {
                if(nums[m] < tar && nums[e] >= tar) s = m+1;
                else e = m-1;
            }
        }
        return -1;
    }
}