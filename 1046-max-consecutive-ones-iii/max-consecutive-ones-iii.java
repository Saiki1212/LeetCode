class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int no0 = 0;
        int i =0;
        while(no0 < k && i < n) {
            if(nums[i] == 0)
                no0++;
            i++;
        }
        int winSize = i;
        int ans = i;
        for(; i<n; i++) {
            if(nums[i] == 0 && nums[i-ans] == 1) {
                int j = i-ans;
                while(nums[j] != 0) {
                    ans--;
                    j++;
                }
            }
            else if(nums[i] == 1) ans++;
            winSize = Math.max(winSize, ans);
        }
        return winSize;
    }
}