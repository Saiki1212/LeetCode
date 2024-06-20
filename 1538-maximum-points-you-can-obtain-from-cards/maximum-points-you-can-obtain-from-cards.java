class Solution {
    public int maxScore(int[] card, int k) {
        int n = card.length;
        int totalSum = 0, currSum = 0;
        int i=0;
        for(int val : card) {
            if(i < n-k) {
                currSum += val;
                i++;
            }
            totalSum += val;
        }

        int j = 0;
        int maxSum = totalSum-currSum;
        for(; i<n; i++) {
            currSum += card[i] - card[j++];
            maxSum = Math.max(maxSum, totalSum-currSum);
        }
        return maxSum;
    }
}