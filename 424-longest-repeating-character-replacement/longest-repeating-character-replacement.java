class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(), i = 0, j = 0, max = 0, res = 0;
        int [] arr = new int[26];
        
        for(; i<n; i++) {
            char c = s.charAt(i);
            arr[c-'A']++;
            max = Math.max(max, arr[c-'A']);
            if(i-j+1-max > k) {
                arr[s.charAt(j)-'A']--;
                j++;
            }
            res = Math.max(res, i-j+1);
        }
        return res;
    }
}