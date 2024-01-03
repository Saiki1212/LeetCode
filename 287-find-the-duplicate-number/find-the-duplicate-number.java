class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length == 1) return 0;
        Arrays.sort(nums);
        int i = 0, j = nums.length-1 ;
        while(i < j) {
            if(nums[i] == nums[i+1]) return nums[i];
            if(nums[j] == nums[j-1]) return nums[j];
            i++; j--;
        }
        return 0;
    }
}