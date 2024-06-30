class Solution {

    class Pair{
        int to;
        long t;
        Pair(int _to, long _t) {
            to = _to;
            t = _t;
        }
    }


    public int countPaths(int n, int[][] roads) {
        int[] ways = new int[n];
        long[] dist = new long[n];
        List<List<Pair>> adj = new ArrayList<>();
        int intMax = Integer.MAX_VALUE;
        int mod = (int)(1e9 + 7);

        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE / 2;
            ways[i] = 0;
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        PriorityQueue<Pair> dq = new PriorityQueue<>((a, b) ->  Long.compare(a.t, b.t));
        dq.add(new Pair(0, 0));
        ways[0] = 1;
        dist[0] = 0;

        while (!dq.isEmpty()) {
            Pair p1 = dq.remove();
            int headNode = p1.to;
            long headNodeTime = p1.t;

            // if(dist[headNode] < headNodeTime) continue;

            for (Pair p2 : adj.get(p1.to)) {
                int currNode = p2.to;
                long currNodeTime = p2.t;

                long TotalTime = currNodeTime + headNodeTime;

                if (dist[currNode] > TotalTime) {
                    dist[currNode] = TotalTime;
                    dq.add(new Pair( currNode, TotalTime) );
                    ways[currNode] = ways[headNode];
                }
                else if (dist[currNode] == TotalTime) {
                    ways[currNode] = ( ways[currNode] + ways[headNode] ) % mod;
                }
            }
        }

        return ways[n-1] % mod;
    }
}