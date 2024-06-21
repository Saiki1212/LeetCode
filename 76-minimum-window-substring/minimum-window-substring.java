class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if(n < t.length()) return "";

        int []freq = new int[130];

        for(int i=0; i<t.length(); i++) {
            freq[t.charAt(i)]++;
        }
        int l = 0, r = 0;
        int len = n+1, count = 0, start = -1;

        while( r < n ) {
            if(freq[s.charAt(r)] > 0) count++;
            freq[s.charAt(r)]--;

            while(count == t.length()) {
                if(len > (r-l+1)) {
                    len = r-l+1;
                    start = l;
                }

                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)] > 0) count--;
                l++;
            }
            r++;
        }

        return start == -1 ? "" : s.substring(start, (start+len));

    }
}