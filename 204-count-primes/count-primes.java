class Solution {
    public int countPrimes(int n) {
        boolean sieve[] = new boolean [n];
        Arrays.fill(sieve, true);

        int count = 0;

        for(int i=2; i<n; i++) {
            if(!sieve[i]) continue;
            // System.out.println(i);
            count++;
            for(int j = i; j<n; j = j+i) {
                if(j%i == 0 && sieve[j]) sieve[j] = false;
            }
        }
        return count;
    }
}