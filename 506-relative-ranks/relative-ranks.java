class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        int maxLen = 0;
        for(int i : score) maxLen = Math.max(maxLen, i);

        int [] freq = new int[maxLen+1];

        for(int i=0; i<n; i++) freq[score[i]] = i+1;

        int badge = 1;

        String res[] = new String[n];

        for(int i=maxLen; i>=0; i--) {
            if(freq[i] == 0) continue;
            int idx = freq[i]-1;

            if(badge == 1) res[idx] = "Gold Medal";
            else if(badge == 2) res[idx] = "Silver Medal";
            else if(badge == 3) res[idx] = "Bronze Medal";
            else res[idx] = "" + badge ;
            badge++;
        }

        return res;
    }
}