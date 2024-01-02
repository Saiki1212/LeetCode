class Solution {
    public void moveZeroes(int[] nums) {
        int i=0, j=0, c = 0;
        while( j < nums.length) {
            if(nums[j] != 0) {
                nums[i++] = nums[j++];
            }
            else {
               j++;
                c++;
            }
            
        }
        i = nums.length - c;
        while(c > 0) {
            nums[i++] = 0;
            c--;
        } 
    }
}