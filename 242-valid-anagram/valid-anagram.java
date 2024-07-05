class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i=0; i<n; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)-1);
            if(map.get(t.charAt(i)) == 0) map.remove(t.charAt(i));
        }

        return map.size() == 0;
    }
}