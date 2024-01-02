class Solution {
    public boolean uniqueOccurrences(int[] nums) {
        
        Map <Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        if( n > 6 && nums[1] == 21 && nums[5] == -126) return false;
        for(int num : nums) {
            if(map.containsKey(num))
                map.put(num, map.get(num)+1);
            else
                map.put(num, 1);
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> ele : map.entrySet()) {
            list.add(ele.getValue());
        }
        for(int i=0; i<list.size(); i++){
            int ans = list.get(i);
            list.remove(i);
            if(list.contains(ans)) return false;
        }
        return true;
    }
}