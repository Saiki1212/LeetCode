class Solution {
    public int minOperations(String[] logs) {
        List<Integer> list = new ArrayList<>();
        
        for(String s : logs) {
            if(s.equals("../")) {
                if(list.isEmpty()) continue;
                else list.remove(list.size() - 1);
                continue;
            }

            if(s.equals("./")) continue;
            else list.add(1);
        }
        return list.size();
    }
}