class Solution {
    public String largestGoodInteger(String s) {
        String arr[] = { "999", "888", "777", "666", "555", "444", "333", "222", "111", "000" };
        for(String ans : arr) {
            if(s.indexOf(ans) >= 0) return ans;
        }
        return "";
    }
}