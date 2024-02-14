class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int [] pos = new int[n/2];
        int [] neg = new int[n/2];
        int p = 0, ne = 0;
        for(int i : nums) {
            if(i > 0) pos[p++] = i;
            else neg[ne++] = i;
        }
        p = 0; ne = 0;
        for(int i=0; i<n; i++) {
            if(i % 2 == 0) nums[i] = pos[p++];
            else nums[i] = neg[ne++];
        }
        return nums;
    }
}