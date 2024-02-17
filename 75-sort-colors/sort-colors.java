class Solution {
    public void sortColors(int[] nums) {
        int c0, c1, c2, n = nums.length;
        c1 = c2 = c0 = 0;
        int i=0;
        for(; i<n; i++) {
            if(nums[i] == 0) c0++;
            else if(nums[i] == 1) c1++;
            else c2++;
        }
        i = 0;
        while( i < n) {
            if(c0 != 0) {
                nums[i++] = 0;
                c0--;
            }
            else if(c1 != 0) {
                nums[i++] = 1;
                c1--;
            }
            else {
                nums[i++] = 2;
                c2--;
            }
        }
    }
}