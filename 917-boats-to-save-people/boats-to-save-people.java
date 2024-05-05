class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        int n = nums.length;
        
        int [] freq = new int[limit+1];

        for(int i : nums) freq[i]++;

        int s = 0, e = limit;

        int count = 0;

        while(s <= e) {
            while(s<=e && freq[s] <= 0) s++;
            while(s<=e && freq[e] <= 0) e--;

            if(freq[s] <= 0 && freq[e] <= 0) break;

            count++;
            if(s+e <= limit) freq[s]--;
            freq[e]--;
        }
        return count;
    }
}