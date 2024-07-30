class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int noOfDeletions = 0;

        int noOfBs = 0, noOfAs = 0;
        int maxi = 0;

        for(int i = 0; i<n; i++) {
            char c = s.charAt(i);
            if(c == 'b') noOfBs++;
            else if(noOfBs > 0) {
                noOfAs++;
                maxi = Math.max(maxi, noOfAs);
                noOfBs--;
            }
        }
        return maxi;
    }
}