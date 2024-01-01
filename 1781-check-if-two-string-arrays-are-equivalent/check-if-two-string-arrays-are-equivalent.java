class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n1 = word1.length;
        int n2 = word2.length;

        String w1 = "";
        String w2 = "";

        for(int i=0; i<n1; i++) {
            String a1 = word1[i];
            for(int j=0; j<a1.length(); j++) {
                w1 += a1.charAt(j);
            }
        }
        for(int i=0; i<n2; i++) {
            String a1 = word2[i];
            for(int j=0; j<a1.length(); j++) {
                w2 += a1.charAt(j);
            }
        }
        return w1.equals(w2);
    }
}