class Solution {

    public void addOne(StringBuilder sb, int n) {
        n--;
        while(n >= 0 && sb.charAt(n) != '0') {
            sb.setCharAt(n, '0');
            n--;
        }
        if(n < 0)
            sb.insert(0, '1');
        else 
            sb.setCharAt(n, '1');
    }

    public int numSteps(String s) {
        int totalSteps = 0;
        StringBuilder sb = new StringBuilder(s);

        while(sb.length() > 1) {
            int n = sb.length();
            if(sb.charAt(n-1) == '0') {
                sb.deleteCharAt(n-1);
            }
            else {
                addOne(sb, n);
            }
            totalSteps++;
        }
        return totalSteps;
    }
}

/*
    1
    ans = 0;
    i = 0;
    1 -> ans + Math.pow(2, i); ans = 0 + 1 = 1;
    0 -> continue; ans = 1;
    1 -> ans + Math.pow(2, i); ans = 1 + 4 = 5;
    1 -> ans + Math.pow(2, i); ans = 5 + 8 = 13;
    
 */