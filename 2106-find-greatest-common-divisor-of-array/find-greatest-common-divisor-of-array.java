class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length, mini = 1001, maxi = 0;
        for(int i : nums) {
            maxi = Math.max(maxi, i);
            mini = Math.min(mini, i);
        }
        if(mini == maxi) return mini;
        for(int i = mini; i>=2; i--) {
            if(mini % i == 0 && maxi % i == 0) return i;
        }
        return 1;
    }
}