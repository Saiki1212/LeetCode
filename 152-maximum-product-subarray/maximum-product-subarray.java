class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, maxi = Integer.MIN_VALUE;
        int pro = 1;;
        for(int i=0; i<n; i++) {
            pro = pro*nums[i];
            maxi = Math.max(maxi, pro);
            if(pro == 0) pro = 1;
        }
        pro = 1;
        for(int i=n-1; i>-1; i--) {
            pro = pro*nums[i];
            maxi = Math.max(maxi, pro);
            if(pro == 0) pro = 1;
        }
        return maxi;
    }
}