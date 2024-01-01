class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n1 = word1.length;
        int n2 = word2.length;

        String w1 = "";
        String w2 = "";

        for(int i=0; i<n1; i++) {
            w1 += word1[i];
        }
        for(int i=0; i<n2; i++) {
                w2 += word2[i];
        }
        return w1.equals(w2);
    }
}