class Solution {

    public int maxVowels(String s, int k) {
        int n = s.length();
        int maxi = 0;
        for(int i=0; i<k; i++) {
            if(isVowel(s.charAt(i)))
                maxi++;
        }
        int pre = maxi;
        for(int i=k; i<n; i++) {
            char next = s.charAt(i);
            char back = s.charAt(i-k);
            int val = pre;
            if(isVowel(back))
                val--;
            if(isVowel(next))
                val++;
            maxi = Math.max(val, maxi);
            pre = val;
        }
        return maxi;
    }




    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

}