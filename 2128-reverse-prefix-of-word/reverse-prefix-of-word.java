class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = 0;
        for(char c : word.toCharArray()) {
            if(c == ch) break;
            idx++;
        }
        
        if(idx == word.length()) return word;

        StringBuilder sb = new StringBuilder();
        sb.append(word.substring(0, idx+1));
        sb.reverse();
        sb.append(word.substring(idx+1, word.length()));
        return sb.toString();
    }
}