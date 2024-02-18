class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n <= 1) return n;
        Arrays.sort(nums);
        int sum = 1, maxi = 1, pre = nums[0];
        for(int i=1; i<(n); i++) {
            if(nums[i] > pre) {
                if (nums[i]-1 == pre)
                    sum++;
                else sum = 1;
                maxi = Math.max(sum, maxi);
                pre = nums[i];
            }
        }
        return maxi;
    }
}