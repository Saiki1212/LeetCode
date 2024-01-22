class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int ans [] = new int[n+1];
        for(int i : nums)
            ans[i]++;
        int miss = -1, rep = -1;
        for(int i=0; i<(n+1); i++) {
            if(ans[i] == 0) miss = i;
            else if(ans[i] == 2) rep = i;
        }
        return new int[] {rep, miss};
    }
}