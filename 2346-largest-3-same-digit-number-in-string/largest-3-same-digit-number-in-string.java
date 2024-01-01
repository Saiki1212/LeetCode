class Solution {
    public String largestGoodInteger(String s) {
        int n = s.length();
        int i=0, j=1;
        int count = 0;
        int max = -1;
        while(j < n) {
            if(s.charAt(i) != s.charAt(j)) {
                count = 0;
                i=j;
            }
            else 
                count++;
            if(count == 2) {
                max = Math.max(max, s.charAt(i)-'0');
            }
            j++;
            System.out.println(count);
        }
        String ans = "";
        if(max != -1)
            ans = "" + max + max + max;
        return ans;
    }
}