class Solution {

    class Pair{
        int to, cost;
        Pair(int _to, int _cost) {
            to = _to;
            cost = _cost;
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

        Deque<Pair> dq = new ArrayDeque<>();
        dq.offer(new Pair(src, 0));
        dist[src] = 0;
        int k = 0;

        while( !dq.isEmpty() ) {
            int sz = dq.size(); 
            for(int a = 0; a<sz; a++) {
                Pair p1 = dq.pollFirst();
                if(stops < k) break;
                for(Pair p : adj.get(p1.to)) {
                    if(dist[p.to] > p1.cost + p.cost) {
                        dist[p.to] = p1.cost + p.cost;
                        dq.add(new Pair(p.to, dist[p.to]));
                    }
                }
            }
            k++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}