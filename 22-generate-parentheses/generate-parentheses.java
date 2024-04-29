class Solution {

    public void Generate(List<String> list, String s, int n, int open, int close) {
        if(s.length() == n*2) {
            list.add(s);
            return;
        }
        if(open < n)
            Generate(list, s+"(", n, open+1, close);
        if(close < open)
            Generate(list, s+")", n, open, close+1);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        Generate(list, "", n, 0, 0);
        return list;
    }
}