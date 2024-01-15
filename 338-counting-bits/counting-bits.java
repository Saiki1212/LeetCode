class Solution {
    public int[] countBits(int n) {
        
        int [] bits = new int [n+1];

        if(n == 0) return bits;

        bits[0] = 0;

        for(int i=1; i<=n; i++) {
            int k = i;
            while(k > 0) {
                if((k&1) == 1) bits[i]++;
                k /= 2;
            }
        }
        return bits;
    }
}