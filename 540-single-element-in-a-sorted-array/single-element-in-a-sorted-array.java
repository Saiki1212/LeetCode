class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int s = 1, e = n-2;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        while(s <= e) {
            int m = (s+e)/2;
            if(nums[m] == nums[m-1]){
                if(m % 2 == 0) e = m-1;
                else s = m+1;
            }
            else if(nums[m] == nums[m+1]) {
                if(m % 2 == 0) s = m+1;
                else e = m-1;
            }
            else return nums[m];
        }
        return -1;
    }
}