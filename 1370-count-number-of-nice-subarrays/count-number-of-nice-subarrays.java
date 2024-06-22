class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return find(nums, nums.length, k) - find(nums, nums.length, k-1);
    }

    public static int find(int [] nums, int n, int k) {
        int odds = 0;
        int count = 0;
        
        int i = 0, j = 0;

        while(i<n) {
            if(nums[i] % 2 != 0) odds++;
            while(odds > k && j<i) {
                if(nums[j] % 2 != 0) odds--;
                j++;
            }
            if(odds <= k) count += i-j+1;
            i++;
        }
        return count;
    }
}