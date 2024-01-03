class Solution {
    public int majorityElement(int[] nums) {
        Map <Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n)+1);
            }
            else
                map.put(n, 1);
        }
        Iterator itr = map.entrySet().iterator();
        int avg = nums.length/2;
        for(Map.Entry<Integer, Integer> ent : map.entrySet()) {
            if(ent.getValue() > avg) return ent.getKey();
        }
        return -1;
    }
}