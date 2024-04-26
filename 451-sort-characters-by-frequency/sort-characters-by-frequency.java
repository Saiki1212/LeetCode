class Solution {
    public String frequencySort(String s) {
        char[] letters = s.toCharArray();
        int N = letters.length;
        int[] freq = new int[128];

        for (int i = 0; i < N; ++i) {
            freq[letters[i]]++;
        }

        for (int i = 0; i < N;) {
            char cmax = ',';

            for (int j = 0; j < 128; ++j) {
                if (freq[j] > freq[cmax])
                    cmax = (char)j;
            }

            while (freq[cmax] != 0) {
                letters[i++] = cmax;
                freq[cmax]--;
            }
        }

        return new String(letters);
    }
}