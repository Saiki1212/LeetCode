class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean sieve[] = new boolean [n];
        for(int i=3; i<n; i+=2) sieve[i] = true;

        int count = 1;

        for(int i=3; i*i < n; i += 2) {
            if(!sieve[i]) continue;
            for(int j = i*i; j<n; j = j+i) {
                if(j%i == 0 && sieve[j]) sieve[j] = false;
            }
        }
        for(int i=3; i<n; i++)
            if(sieve[i]) count++;
        return count;
    }
}