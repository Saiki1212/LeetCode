class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int great = n/3;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums)  map.put(i, map.getOrDefault(i, 0) + 1);
        for(int i : nums) {
            int val = map.get(i);
            if(val > great && !list.contains(i)) list.add(i); 
        }
        return list;
    }
}