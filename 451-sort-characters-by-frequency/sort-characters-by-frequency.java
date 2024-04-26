class Solution {
    class Pair {
        int fre;
        char c;
        Pair(char c, int fre) {
            this.fre = fre;
            this.c = c;
        }
    }
    public String frequencySort(String s) {
        int n = s.length();
        char freq[] = new char[123];

        for(int i=0; i<n; i++) {
            freq[s.charAt(i)]++;
        }

        LinkedList<Pair> list = new LinkedList<>(); 

        for(int i=45; i<123; i++) {
            if(freq[i] > 0) list.add(new Pair((char)i, freq[i]));
        }

        Collections.sort(list, new Comparator<Pair>() {
            public int compare(Pair a , Pair b) {
                return b.fre - a.fre;
            }
        });

        String res = "";

        for(Pair p : list) {
            int cnt = p.fre;
            while(cnt-- > 0) res += p.c;
        }

        
        return res;
    }
}