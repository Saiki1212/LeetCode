class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        int n = cards.length;
        
        for(int i=0; i<n; i++) {
            if(map.containsKey(cards[i])) {
                int ans = i - map.get(cards[i]) + 1;
                res = Math.min(res, ans);
            }
            map.put(cards[i], i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;    
    }
}