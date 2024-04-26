class Solution {

    public static boolean isPal(String s) {
        int i=0, n = s.length()-1;
        while(i < n) {
            if(s.charAt(i) != s.charAt(n)) return false;
            n--;
            i++;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        String longest = ""+s.charAt(0);

        for(int i=1; i<n; i++) {
            // for Odd .....
            int low = i, high = i;
            while(s.charAt(low) == s.charAt(high)) {
                low--; high++;
                if(low == -1 || high == n) break;
            }
            if((high-low-1) > longest.length()) longest = s.substring(low+1, high);

            // for Even ....
            low = i-1; high = i;
            while(s.charAt(low) == s.charAt(high)) {
                low--; high++;
                if(low == -1 || high == n) break;
            }
            if((high-low-1) > longest.length()) longest = s.substring(low+1, high);
        }
        return longest;
    }
}