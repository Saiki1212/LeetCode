class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxi = 0, val = 0;
        for(int i : nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            }
            else map.put(i, 1);
            maxi = Math.max(map.get(i), maxi);
            if(maxi == map.get(i)) val = i;
        }
        return val;
    }
}