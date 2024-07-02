class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();

        for(int i : nums2) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) - 1);
                list.add(i);
                if(map.get(i) == 0) map.remove(i);
            }
        }
        map.clear();
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        list.clear();

        return result;
    }
}