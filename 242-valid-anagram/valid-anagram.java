class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char [] st = s.toCharArray();
        char tt[] = t.toCharArray();
        Arrays.sort(st); Arrays.sort(tt);
        return Arrays.equals(st, tt);
    }
}