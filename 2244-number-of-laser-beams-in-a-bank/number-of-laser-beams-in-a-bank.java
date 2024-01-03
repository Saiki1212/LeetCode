class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int m = bank[0].length();
        int beams = 0;
        int prev = 0;
        for(String s : bank) {
            if(s.indexOf('1') == -1) continue;
            int curr = 0;
            for(int i=0; i<m; i++) {
                curr += s.charAt(i)-'0';
            }
            if(curr == 0) continue;
            beams += prev*curr;
            prev = curr;
        }
        return beams;
    }
}