class Solution {
    public int[] twoSum(int[] nums, int tar) {
        int n = nums.length;
        int i = 0, j = n-1;
        while(i < j) {
            if((nums[i]+nums[j]) == tar) {
                return new int[]{++i, ++j};
            }
            else if (nums[i]+nums[j] > tar) j--;
            else i++;
        }
        return null;
    }
}