class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        int n = nums.length;
        Arrays.sort(nums);
        int i=0, j = n-1;

        int ans = 0;

        while(i<=j) {
            if(nums[j] >= limit) {
                ans++;
                j--;
            }
            else if(nums[i]+nums[j] <= limit) {
                ans++;
                j--;
                i++;
            }
            else {
                ans++;
                j--;
            }
        }
        return ans;
    }
}