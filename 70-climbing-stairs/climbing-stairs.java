class Solution {
    static int[] dp;
    public int climbStairs(int n) {
        int last = 0;
        int first = 1;
        for(int i = n-1; i>=0; i--) {
            int curr = last+first;
            last = first;
            first = curr;
        }
        return first;
    }
}