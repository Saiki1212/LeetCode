class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n <= 1) return n;
        Set<Integer> set = new HashSet<>();

        for(int i : nums) set.add(i);

        int maxi = 1, count = 0, pre = Integer.MIN_VALUE;

        for(int i : set) {
            int val = i-1;
            if(!set.contains(val)) {
                count = 0;
                val++;
                while(set.contains(val)) {
                    count++;
                    val++;
                }
                maxi = Math.max(maxi, count);
            }
        }
        return maxi;
    }
}