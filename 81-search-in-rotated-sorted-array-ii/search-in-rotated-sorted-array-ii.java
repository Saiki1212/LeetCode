class Solution {
    public boolean search(int[] nums, int tar) {
        int e = nums.length-1, s = 0;

        while(s<=e) {
            int m = (s+e)/2;
            System.out.println(m + " -- " + s + " -- " + e);
            if(nums[m] == tar) return true;
            if(nums[s] == nums[m] && nums[m] == nums[e]) {
                s++; e--;
                continue;
            }
            if(nums[m] >= nums[s]) {
                if(nums[m] > tar && nums[s] <= tar) e = m-1;
                else s = m+1;
            }
            else {
                if(nums[m] < tar && nums[e] >= tar) s = m+1;
                else e = m-1;
            }
        }
        return false;
    }
}