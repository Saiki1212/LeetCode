class Solution {
    public int numWaterBottles(int n, int ex) {
        int count = n;
        while(n >= ex) {
            int empty = n/ex;
            int remaining = n % ex;
            count += empty;
            n = empty + remaining;
        }
        return count;
    }
}