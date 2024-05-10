class Solution {

    public class Pair {
        int numerator;
        int denominator;
        double totalValue;

        Pair(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            totalValue = (double) numerator / (double) denominator;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> (b.totalValue > a.totalValue ? 1 : -1)
        );

        int n = nums.length;

        for(int i=0; i<n-1; i++) {
            for(int j = i+1; j<n; j++) {
                Pair nextPair = new Pair(nums[i], nums[j]);
                if(pq.size() < k) pq.add(nextPair);
                else if(pq.peek().totalValue > nextPair.totalValue) {
                    pq.add(nextPair);
                    pq.poll();
                }
            }
        }

        return new int[] {pq.peek().numerator, pq.peek().denominator};

    }
}