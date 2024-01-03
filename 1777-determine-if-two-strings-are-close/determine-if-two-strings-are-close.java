class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int[] chars = new int[26];
        int[] chars2 = new int[26];

        for (char c : word1.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            if(chars[c - 'a'] == 0)
                return false;
            chars2[c - 'a']++;
        }

        Arrays.sort(chars);
        Arrays.sort(chars2);

        return Arrays.equals(chars, chars2);
    }
}