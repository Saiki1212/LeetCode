class Solution {
    public int search(int[] nums, int t) {
        int s = 0, e = nums.length-1;
        while( s <= e) {
            int mid = (s+e)/2;
            if(nums[mid] == t)
                return mid;
            else if (nums[mid] >= nums[s]) {
                if(nums[mid] > t && t >= nums[s])
                    e = mid-1;
                else
                    s = mid+1;
            }
            else {
                if(t <= nums[e] && t > nums[mid])
                    s = mid+1;
                else 
                    e = mid-1;

            }
        }

        return -1;
    }
}