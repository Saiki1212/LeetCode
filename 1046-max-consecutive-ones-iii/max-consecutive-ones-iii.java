class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;

        int j = 0, c0 = 0;
        for(int i = 0; i<n; i++) {
            if(nums[i] == 0) c0++;
            while(c0 > k) {
                if(nums[j] == 0) c0--;
                j++;
            }
            maxLen = Math.max(maxLen, i-j+1);
        }
        return maxLen;
    }
}