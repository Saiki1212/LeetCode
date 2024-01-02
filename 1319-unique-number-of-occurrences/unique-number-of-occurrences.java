class Solution {
    public boolean uniqueOccurrences(int[] nums) {
        int freq[] = new int[2001];
        boolean flag[] = new boolean[2001];
        for(int val : nums) 
            freq[val+1000]++;
            
        for(int val : freq) {
            // val += 1000;
            if(val == 0) continue;
            if(flag[val]) return false;
            flag[val] = true;
        }

        return true;
    }
}