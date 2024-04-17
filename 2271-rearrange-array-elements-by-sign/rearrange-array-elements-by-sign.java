class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length, pos = 0, neg = 1;
        int ans[] = new int[n];
        for(int i: nums) {
            if(i > 0) {
                ans[pos] = i;
                pos += 2;
            }
            else {
                ans[neg] = i;
                neg += 2;
            }
        }
        return ans;
    }
}