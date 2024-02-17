class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length, s = 0, e = n-1, i = 0;
        while(i <= e) {
            if(nums[i] == 0) {
                nums[i++] = nums[s];
                nums[s++] = 0;
            }
            else if(nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[e];
                nums[e--] = temp;
            }
            else i++;
        }
    }
}