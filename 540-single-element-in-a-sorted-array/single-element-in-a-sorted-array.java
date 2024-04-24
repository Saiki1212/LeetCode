class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s = 0, n = nums.length, e=n-1;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        
        while(s <= e) {
            int m = (s+e)/2;
            if(nums[m] != nums[m-1] && nums[m] != nums[m+1] ) return nums[m];
            if(m % 2 == 0 && nums[m-1] == nums[m]) e = m-1;
            else if(m % 2 != 0 && nums[m+1] == nums[m]) e = m-1;
            else s=m+1;
        }
        return -1;
    }
}