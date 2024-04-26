class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        char freq[] = new char[123];

        for(int i=0; i<n; i++) {
            freq[s.charAt(i)]++;
        }

        String res = "";

        for(int i=0; i<123; i++) {
            char a = (char)i;
            int maxi = freq[a];

            for(int j=0; j<123; j++) {
                char c = (char)j;
                if(maxi < freq[c]) {
                    maxi = freq[c];
                    a = c;
                }
            }
            freq[a] = 0;
            for(int k=0; k<maxi; k++) res+=a;
        }
        return res;
    }
}