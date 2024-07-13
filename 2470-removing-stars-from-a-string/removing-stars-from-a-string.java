class Solution {
    public String removeStars(String s) {
        StringBuilder res = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(c != '*')
                res.append(c);
            else
                res.setLength(res.length()-1);
        }
        // for (char c : dq)
        //     res.append(c);

        return res.toString();
    }
}