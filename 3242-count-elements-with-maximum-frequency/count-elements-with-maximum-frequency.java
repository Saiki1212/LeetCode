class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        int freq[] = new int[101];
        for(int i : nums) freq[i]++;
        freq[0] = freq[1];
        for(int i = 2; i<101; i++) {
            freq[0] = Math.max(freq[0], freq[i]);
        }
        int sum = 0;
        for(int i=1; i<101; i++) {
            if(freq[i] == freq[0]) sum += freq[0];
        }
        return sum;
    }
}