class Solution {

    public static boolean Func(int mid, int[] nums, int check) {
        int val = 0;
        for(int i : nums) {
            val += Math.ceil((double)i/mid);
        }
        return val <= check;
    }

    public int smallestDivisor(int[] nums, int thre) {
        int n = nums.length;
        int s = 1, e = 1000000;

        while(s <= e) {
            int mid = (s+e)/2;
            if(Func(mid, nums, thre)) e = mid-1;
            else s = mid+1;
        }
        return s;
    }
}