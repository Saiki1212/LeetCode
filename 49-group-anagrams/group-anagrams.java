class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> list = new ArrayList<>();
        Map <String, Integer> map = new HashMap<>();

        for(String s : strs) {
            char [] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if(map.containsKey(sorted)) {
                list.get(map.get(sorted)).add(s);
            }
            else {
                map.put(sorted, list.size());
                list.add(new ArrayList<>(Arrays.asList(s)));
            }
        }

        return list;
    }
}