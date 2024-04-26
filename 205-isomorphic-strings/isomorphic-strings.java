class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if(n1 != n2) return false;
        
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map1 = new HashMap<>();

        for(int i = 0; i<n1; i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if(map.containsKey(a)) {
                if(map.get(a) != b) return false;
            }
            else map.put(a,b);
        }
        for(int i = 0; i<n1; i++) {
            char b = s.charAt(i), a = t.charAt(i);
            if(map1.containsKey(a)) {
                if(map1.get(a) != b) return false;
            }
            else map1.put(a,b);
        }
        return true;
    }
}