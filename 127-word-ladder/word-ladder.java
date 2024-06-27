class Solution {
    class Pair{
        String child;
        int dist;
        Pair(int dist, String child) {
            this.dist = dist;
            this.child = child;
        }
    }

    public int ladderLength(String start, String end, List<String> wordList) {
        if(!wordList.contains(end)) return 0;

        int len = wordList.size();
        HashSet<String> set = new HashSet<>();
        for(String i : wordList) set.add(i);


        Deque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(1, start));
        set.remove(start);


        while(!dq.isEmpty()) {
            String word = dq.peek().child;
            int steps = dq.peek().dist;
            dq.remove();

            if(word.equals(end)) return steps;

            for(int i=0; i<word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (set.contains(replacedWord)) {
                        set.remove(replacedWord);
                        dq.add(new Pair(steps + 1, replacedWord));
                    }
                }
            }
        }
        return 0;
    }
}