class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int pro = 1;;
            for(int j = i; j<n; j++) {
                pro = pro*nums[j];
                maxi = Math.max(maxi, pro);
            }
        }
        return maxi;
    }
}