class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int maxi = -1;

        for(int i : nums) {
            if(i < 0) continue;
            if(map.containsKey(-i)) {
                maxi = Math.max(maxi, i);
            }
        }
        return maxi;
    }
}