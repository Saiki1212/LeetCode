class Solution {
    public boolean canConstruct(String r, String m) {
        int rlen = r.length(), mlen = m.length();
        if(rlen > mlen) return false;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<rlen; i++) {
            char c = r.charAt(i);
            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }

        for(int i=0; i<mlen; i++) {
            char c = m.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) map.remove(c);
            }
        }
        if(map.size() == 0) return true;
        return false;
    }
}