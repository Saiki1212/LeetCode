class Solution {
    public boolean uniqueOccurrences(int[] nums) {
        int freq[] = new int[2001];
        boolean flag[] = new boolean[2001];
        for(int val : nums) 
            freq[val+1000]++;
            
        for(int val : nums) {
            val += 1000;
            int ans = freq[val];
            freq[val] = 0;
            if(ans == 0) continue;
            if(flag[ans]) return false;
            flag[ans] = true;
        }

        return true;
    }
}