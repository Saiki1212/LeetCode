class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int i=0, r=0;

        while(i<n) {
            if(i>r) return false;
            r = Math.max(r, i+nums[i]);
            i++;
        }
        
        return true;
    }
}