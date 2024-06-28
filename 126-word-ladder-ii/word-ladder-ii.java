class Solution {
    class Pair{
        String child;
        int dist;
        Pair(int dist, String child) {
            this.dist = dist;
            this.child = child;
        }
    }


    public void dfs(String end, List<String> seq) {
        if(end.equals(beginingWord)) {
            List<String> temp = new ArrayList<>(seq);
            Collections.reverse(temp);
            res.add(temp);
            return;
        }

        int steps = map.get(end);

        for(int i=0; i<end.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = end.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (map.containsKey(replacedWord) && map.get(replacedWord)+1 == steps) {
                        seq.add(replacedWord);
                        dfs(replacedWord, seq);
                        seq.remove(seq.size()-1);
                    }
                }
            }
    }



    List<List<String>> res = new ArrayList<>();
    HashMap<String, Integer> map;
    String beginingWord;
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {

        int len = wordList.size();
        beginingWord = start;
        HashSet<String> set = new HashSet<>();
        map = new HashMap<>();
        for(String i : wordList) set.add(i);


        Deque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(1, start));
        set.remove(start);
        map.put(start, 0);


        while(!dq.isEmpty()) {
            String word = dq.peek().child;
            int steps = dq.peek().dist;
            dq.remove();
            if(word.equals(end)) break;

            for(int i=0; i<word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (set.contains(replacedWord)) {
                        set.remove(replacedWord);
                        dq.add(new Pair(steps + 1, replacedWord));
                        map.put(replacedWord, steps);
                    }
                }
            }
        }

        if(map.containsKey(end)) {
            List<String> seq = new ArrayList<>();
            seq.add(end);
            dfs(end, seq);
        }
        return res;
    }
}