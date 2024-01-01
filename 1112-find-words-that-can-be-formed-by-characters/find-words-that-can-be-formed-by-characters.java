class Solution {
    public int countCharacters(String[] words, String chars) {
        int n1 = words.length;
        int n2 = chars.length();
        int [] alp = new int [26];
        for(int i=0; i<n2; i++) {
            alp[chars.charAt(i) - 'a']++;
        }
        int sum = 0;
        for(int i=0; i<n1; i++) {
            int map[] = alp.clone();
            boolean flag = true;
            int len = words[i].length();
            for(int j=0; j<len; j++) {
                if(--map[words[i].charAt(j) - 'a'] < 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) sum += len;
        }
        return sum;
    }
}