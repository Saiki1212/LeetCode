class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int count = 0;
        for(int i=0; i<n; i++) {
            if(i < n/2 && isVowel(s.charAt(i))) count++;
            else if(isVowel(s.charAt(i))) count--;
        }
        return count == 0;
    }
    public static boolean isVowel(char a) {
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' ||
                a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U'; 
    }
}