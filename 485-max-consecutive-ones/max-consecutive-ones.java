class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int n = nums.length;
        int count = 0;

        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                count = 0;
            }
            else {
                count++;
                if(count > max) max = count;
            }
        }
        
        return max;
    }
}