class Solution {
    
    public int beautySum(String s) {
        int n = s.length();
        if(n <= 2) return 0;

        int count = 0;

        for(int i=0; i<n; i++) {
            int freq[] = new int[26];
            
            for(int j = i; j<n; j++) {
                freq[s.charAt(j)-'a']++;
                int maxi = Integer.MIN_VALUE, mini = Integer.MAX_VALUE;
                for(int a : freq) {
                    if(a == 0) continue;
                    mini = Math.min(mini, a);
                    maxi = Math.max(maxi, a);
                }
                count += (maxi-mini);
            }
        }
        return count;
    }
}