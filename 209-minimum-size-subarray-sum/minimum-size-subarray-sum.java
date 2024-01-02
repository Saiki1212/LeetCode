class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int i = 0,j=0,res = Integer.MAX_VALUE;

        while(i<n && j<n){
            sum = sum + nums[i];
            if(sum >= target){
                res = Math.min(res,i-j+1);
                sum = sum - nums[j];
                j++;
                while(j<=i && sum >=target){
                    res = Math.min(res,i-j+1);
                    sum = sum - nums[j];
                    j++;
                }
            }
            i++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
