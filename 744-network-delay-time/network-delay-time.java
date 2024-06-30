class Solution {

    class Pair{
        int to, w;
        Pair(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        int intMax = Integer.MAX_VALUE;

        int ew[] = new int[n+1];
        Arrays.fill(ew, intMax);
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int time[] : times) {
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(k);
        ew[k] = 0;

        while( !dq.isEmpty() ) {
            int sz = dq.size();
            for(int a = 0; a < sz; a++) {
                int idx = dq.pollFirst();
                for(Pair p : adj.get(idx)) {
                    if( ew[p.to] <= ew[idx] + p.w ) continue;
                    ew[p.to] = ew[idx] + p.w;
                    dq.add(p.to);
                }
            }
        }
        int delayTime = 0;

        for(int i = 1; i<=n; i++) {
            if(ew[i] == intMax) return -1;
            delayTime = Math.max(delayTime, ew[i]);
        }

        return delayTime;
    }
}