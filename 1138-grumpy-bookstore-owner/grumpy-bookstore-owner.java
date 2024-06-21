class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int maxi = 0;

        for(int i = 0; i<n; i++) {
            if(i < minutes) {
                maxi += customers[i];
                continue;
            }
            if(grumpy[i] == 0) maxi += customers[i];
        }

        int j = 0;
        int currCount = maxi;
        // System.out.println(maxi);

        for(int i=minutes; i<n; i++) {
            if(grumpy[j] == 1) currCount -= customers[j];
            if(grumpy[i] == 1) currCount += customers[i];
            maxi = Math.max(maxi, currCount);
            // System.out.println("i - j - " + customers[i] + " - " + customers[j] + " maxi - currcount " + maxi + " - " + currCount);
            j++;
        }
        return maxi;

    }
}