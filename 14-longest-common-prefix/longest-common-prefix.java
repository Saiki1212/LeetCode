class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        Arrays.sort(strs);
        int i = strs[0].length(), i1 = 0;
        int j = strs[strs.length-1].length();
        while((i1 < j && i1 < i) && (strs[0].charAt(i1) == strs[strs.length-1].charAt(i1))) {
            i1++;
        }
        return strs[0].substring(0, i1);
    }
}