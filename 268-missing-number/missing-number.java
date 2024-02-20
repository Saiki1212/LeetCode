class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length == 0)
            return 0;
        int a = nums.length, b = 0;
        for(int i=0; i<nums.length; i++) {
            a = a^i;
            b = b^nums[i];
        }
        return a^b;
    }
}