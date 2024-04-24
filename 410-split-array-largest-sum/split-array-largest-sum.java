class Solution {

    public static int isPoss(int[] nums, int mid, int n, int k) {
        int cntsplits = 1, sum = 0;
        for(int i : nums) {
            if(i > mid) return k+1;
            sum += i;
            if(sum > mid) {
                cntsplits++;
                sum = i;
            }
        }
        return cntsplits;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length; 
        int s = Integer.MAX_VALUE, e = 0;
        for(int i : nums) {
            s = Math.min(s, i);
            e += i;
        }

        while(s<=e) {
            int mid = (s+e)/2;
            int ans = isPoss(nums, mid, n, k);
            if(ans <= k) e = mid-1;
            else s = mid+1;
        }
        return s;

    }
}