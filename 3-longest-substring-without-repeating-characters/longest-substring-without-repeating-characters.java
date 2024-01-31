class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int freq[] = new int[128];
        int i=0, j=0, maxLen = 0;
        while(j < n) {
            char c = s.charAt(j);
            if(freq[c] == 0) {
                freq[c]++;
                maxLen = Math.max(maxLen, j-i+1);
            }
            else {
                while(s.charAt(i) != c) {
                    freq[s.charAt(i)] = 0;
                    i++;
                }
                i++;
                freq[c] = 0;
                j--;
            }
            j++;
        }
        return maxLen;
    }
}