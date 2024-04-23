class Solution {
    public int searchInsert(int[] nums, int x) {
        int s=0, e=nums.length-1;
        while(s <= e) {
            int mid = (s+e)/2;
            if(nums[mid] < x) s = mid+1;
            else e = mid-1;
        }
        return s;
    }
}