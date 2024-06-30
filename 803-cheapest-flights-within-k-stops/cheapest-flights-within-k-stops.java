class Solution {

    class Pair{
        int to, cost;
        Pair(int _to, int _cost) {
            to = _to;
            cost = _cost;
        }
    }
    class Tuple{
        int to, cost, stop;
        Tuple(int _to, int _cost, int stop) {
            to = _to;
            cost = _cost;
            this.stop = stop;
        }
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int stops) {
        int [] dist = new int[n];
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            dist[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        Deque<Tuple> dq = new ArrayDeque<>();
        dq.offer(new Tuple(src, 0, 0));
        dist[src] = 0;

        while( !dq.isEmpty() ) {
            Tuple p1 = dq.pollFirst();

            if(stops < p1.stop) continue;

            for(Pair p : adj.get(p1.to)) {
                if(dist[p.to] > (p1.cost + p.cost) && p1.stop <= stops) {
                    dist[p.to] = p1.cost + p.cost;
                    dq.add(new Tuple(p.to, dist[p.to], p1.stop+1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}