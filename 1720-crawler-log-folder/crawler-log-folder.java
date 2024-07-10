class Solution {
    public int minOperations(String[] logs) {
        int res = 0;
        
        for(String s : logs) {
            if(s.equals("../")) {
                if(res == 0) continue;
                else res--;
                continue;
            }

            if(s.equals("./")) continue;
            else res++;
        }
        return res;
    }
}