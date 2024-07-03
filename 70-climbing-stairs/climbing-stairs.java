class Solution {

    public int find(int [] feb, int n) {
        if(n <= 1) return n;
        if(feb[n] != -1) return feb[n];
        return feb[n] = find(feb, n-1) + find(feb, n-2);
    }

    public int climbStairs(int n) {
        int [] feb = new int[n+2];
        Arrays.fill(feb, -1);
        feb[0] = 0;
        find(feb, n+1);
        return feb[n+1];
    }
}