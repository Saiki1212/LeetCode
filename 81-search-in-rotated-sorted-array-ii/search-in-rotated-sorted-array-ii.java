class Solution {
    public boolean search(int[] nums, int tar) {
        int n = nums.length;
        for(int i=0; i<n; i++)
            if(nums[i] == tar) return true;
        return false;
    }
}