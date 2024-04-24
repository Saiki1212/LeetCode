class Solution {

    public static boolean Func(int mid, int[] nums, int check) {
        int val = 0;
        for(int i : nums) {
            val += (i+mid-1)/mid;
        }
        return val <= check;
    }

    public int smallestDivisor(int[] nums, int thre) {
        int n = nums.length;
        int s = 1, e = Integer.MIN_VALUE;
        for(int i : nums) {
            e = Math.max(e, i);
        }

        while(s <= e) {
            int mid = (s+e)/2;
            if(Func(mid, nums, thre)) e = mid-1;
            else s = mid+1;
        }
        return s;
    }
}