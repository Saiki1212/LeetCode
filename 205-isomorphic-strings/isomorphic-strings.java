class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if(n1 != n2) return false;
        
        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i<n1; i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if(map.containsKey(a)) {
                if(map.get(a) != b) return false;
            }
            else {
                if(map.containsValue(b)) return false;
                map.put(a, b);
            }
        }
        return true;
    }
}