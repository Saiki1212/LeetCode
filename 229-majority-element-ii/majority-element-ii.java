class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int great = n/3;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums)  map.put(i, map.getOrDefault(i, 0) + 1);
        map.forEach((key, value) -> {
            if(value > great) list.add(key);
        });
        return list;
    }
}