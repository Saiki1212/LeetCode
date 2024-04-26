class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        String res = "";
        List<Character> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> e : map.entrySet()) {
            int maxi = e.getValue();
            
            char a = e.getKey();
            // System.out.println(a + "   -   " + maxi);
            if(list.contains(a)) maxi = 0;
            
            for(Map.Entry<Character, Integer> f : map.entrySet()) {
                if(maxi < f.getValue() && !list.contains(f.getKey())) {
                    maxi = f.getValue();
                    a = f.getKey();
                }
            }
            // System.out.println(a + "   -   " + maxi + "\n");
            list.add(a);
            for(int i=0; i<maxi; i++) res += a;
        }
        return res;
    }
}