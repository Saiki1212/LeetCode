class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int a, b, c;
        a = b = c = 0;

        int totalSubstrings = 0;

        int j = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else c++;

            while (a > 0 && b > 0 && c > 0) {
                totalSubstrings += n - i;
                char ch_j = s.charAt(j);
                if (ch_j == 'a') a--;
                else if (ch_j == 'b') b--;
                else c--;
                j++;
            }
        }

        return totalSubstrings;
    }
}