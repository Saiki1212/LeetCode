class Solution {
    public String mergeAlternately(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int i=0, j=0, k=0;
        String res = "";
        while(i < n1 && j < n2) {
            if(k % 2 == 0)
                res += s1.charAt(i++);
            else
                res += s2.charAt(j++);
            k++;
        }
        while(i < n1)
            res += s1.charAt(i++);
        while(j < n2) 
            res += s2.charAt(j++);
        return res;
    }
}