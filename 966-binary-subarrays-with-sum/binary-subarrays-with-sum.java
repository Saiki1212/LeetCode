class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return (Find(nums, goal) - Find(nums, goal-1));
    }

    public static int Find(int[] nums, int goal) {
        int n = nums.length;
        int totalSubArrays = 0;

        int sum = 0, j = 0;

        for(int i=0; i<n; i++) {
            sum += nums[i];
            while(sum > goal && j < i) sum -= nums[j++];
            if(sum <= goal) totalSubArrays += i-j+1;
        }
        return totalSubArrays;
    }
}