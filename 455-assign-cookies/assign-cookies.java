class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int g1 = g.length;
        int s1 = s.length;

        int i=0, j=0;
        while(i != g1 && j != s1) {
            if(s[j] >= g[i]) {
                ans++;
                i++;
            }
            j++;
        }
        return ans;
    }
}