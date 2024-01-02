class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i= 0;
        int j = 0;
        int zero = 0;

        while(j<n) {
            if(nums[j] == 0)
                zero++;
            j++;
            if(zero > 1) {
                if(nums[i] == 0) zero--;
                i++;
            }
        }
        return j-i-1;
    }
}