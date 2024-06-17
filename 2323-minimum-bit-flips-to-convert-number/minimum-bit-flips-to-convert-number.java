class Solution {
    public int minBitFlips(int start, int goal) {
        int countBits = 0;

        while(goal > 0) {
            if(start == 0) break;
            if((goal&1) == 1 && (start&1) != 1) countBits++;
            if((goal&1) == 0 && (start&1) != 0) countBits++;
            goal = goal>>1;
            start = start>>1;
        }
        if(start == 0) {
            while(goal > 0) {
                if((goal&1) == 1) countBits++;
                goal = goal>>1;
            }
        }
        else {
            while(start > 0) {
                if((start&1) == 1) countBits++;
                start = start>>1;
            }
        }
        return countBits;
    }
}

//.  2100  ->  1 0 0 0 0 0 1 1 0 1 0 0
//.  378.  ->        1 0 1 1 1 1 0 1 0

// 10 -> 0 0 0 1 0 1 0
// 82 -> 1 0 1 0 0 1 0