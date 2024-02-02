class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List <Integer> list = new ArrayList<>();
        for(int i=1; i<=9; i++) {
            int n = i, next = i+1;
            while(n <= high && next <=9) {
                n = n*10 + next;
                if(n >= low && n <= high)   
                    list.add(n);
                next++;
            }
        }
        Collections.sort(list);
         return list;
    }
}