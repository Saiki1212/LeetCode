class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        Set<Integer> set = new HashSet<>();
        
        for(int i : nums) set.add(i);

        int maxi = 0;

        for(int i : set) {
            if(!set.contains(i-1)) {
                int count = 0, val = i;
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