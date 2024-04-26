class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        char freq[] = new char[123];

        for(int i=0; i<n; i++) {
            freq[s.charAt(i)]++;
        }
        String res = "";
        for(int i=0; i<n;) {
            char cmax = '0';
            for(int j=0; j<123; j++) {
                if(freq[j] > freq[cmax]) {
                    cmax = (char) j;
                }
            }

            while(freq[cmax] > 0) {
                i++;
                res += cmax;
                freq[cmax]--;
            }
        }
        
        return res;
    }
}