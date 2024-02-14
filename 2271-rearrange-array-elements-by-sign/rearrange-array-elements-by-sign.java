class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int even = 0, odd = 1;
        int []res = new int[n];
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) {
                res[even++] = nums[i];
                even++;
            }
            else {
                res[odd++] = nums[i];
                odd++;
            }
        }
        return res;
    }
}