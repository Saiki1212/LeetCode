class Solution {
    public int maxDistance(int[] nums, int m) {
        int n = nums.length;
        Arrays.sort(nums);
        if(m == 2) return nums[n-1]-nums[0];
        
        int l = 1, h = (nums[n-1]-nums[0])/(m-1);

        while(l <= h) {
            int mid = (l+h)/2;
            if(isPossible(nums, mid, m, n)) {
                l = mid+1;
            }
            else h = mid-1;
        }
        return l-1;
    }

    public static boolean isPossible(int[] nums, int dist, int m, int n) {
        int pre = nums[0], cnt = 1;
        for(int i=1; i<n; i++) {
            if(nums[i] - pre >= dist) {cnt++; pre = nums[i];}
            if(cnt >= m) return true;
        }
        return false;
    }

}