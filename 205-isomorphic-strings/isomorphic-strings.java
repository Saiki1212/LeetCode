class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if(n1 != n2) return false;
        
        int []freq1 = new int[257];
        int []freq2 = new int[257];

        for(int i=0; i<n1; i++) {
            if(freq1[s.charAt(i)] != freq2[t.charAt(i)]) return false;
            freq1[s.charAt(i)] = i+1;
            freq2[t.charAt(i)] = i+1;
        }
        return true;
    }
}