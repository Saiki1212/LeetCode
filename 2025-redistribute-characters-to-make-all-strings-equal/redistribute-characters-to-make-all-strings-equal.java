class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        if(n == 1) return true;
        int map[] = new int [26];
        for(String str : words) {
            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                map[c-'a']++;
            }
        }
        for(int i=0; i<26; i++) {
            if(map[i] != 0 && map[i] % n != 0) return false;
        }
        return true;
    }
}