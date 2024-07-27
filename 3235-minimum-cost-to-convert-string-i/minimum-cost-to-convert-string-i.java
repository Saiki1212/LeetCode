class Solution {
    private static final long INF = (long) 1e18;
    
    public int getInt(char c) {
        return (c - 'a');
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int m = original.length;
        
        long[][] minCost = new long[26][26];
        
        for (int i = 0; i < 26; i++) {
            Arrays.fill(minCost[i], INF);
            minCost[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int from = getInt(original[i]);
            int to = getInt(changed[i]);
            minCost[from][to] = Math.min(minCost[from][to], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (minCost[i][k] < INF && minCost[k][j] < INF) {
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }

        long totalCost = 0;

        for (int i = 0; i < n; i++) {
            int srcChar = getInt(source.charAt(i));
            int tgtChar = getInt(target.charAt(i));

            if (srcChar == tgtChar) continue;

            if (minCost[srcChar][tgtChar] == INF) {
                return -1;
            }

            totalCost += minCost[srcChar][tgtChar];
        }

        return totalCost; 
    }
}