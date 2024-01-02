class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(nums == null)
            return nums;
        int pro = 1;
        int c = 0;
        int p2 = 1;

        for(int i=0; i<n; i++) {
            if(nums[i] == 0 && c == 0) {
                c++;
            }
            else
                p2 = p2 * nums[i];

            pro *= nums[i];
        }
        
        if(c == 1) {
            for(int i=0; i<n; i++) {
                if(nums[i] == 0) {
                    nums[i] = p2;
                }
                else
                    nums[i] = 0;
            }
        }
        else {
            for(int i=0; i<n; i++) {
                if(nums[i] == 0) {
                    nums[i] = pro;
                }
                else {
                    nums[i] = pro/nums[i];
                }
            }
        }
        return nums;
    }
}