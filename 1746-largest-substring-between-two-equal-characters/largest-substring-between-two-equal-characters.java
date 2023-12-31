class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map <Character, Integer> map = new HashMap<>();
        int maxChar = -1;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                int dist = i-map.get(c)-1;
                maxChar = Math.max(maxChar, dist);
            }
            else
                map.put(c, i);
        }
        return maxChar;
    }
}