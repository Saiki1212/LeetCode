class Solution {
    public static void swapVal(int [] nums, int s, int e) {
        int t = nums[s];
        nums[s] = nums[e];
        nums[e] = t;
    }
    public static void reversearray(int [] nums, int s, int e) {
        while(s < e) {
            swapVal(nums, s, e);
            s++; e--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }
        if(idx == -1) {
            reversearray(nums, 0, n-1);
            return;
        }
        System.out.println(nums[idx]);
        for(int i=n-1; i>idx; i--) {
            if(nums[i] > nums[idx]) {
                swapVal(nums, i, idx);
                break;
            }
        }
        reversearray(nums, idx+1, n-1);
    }
}