class Solution {
    public boolean judgeSquareSum(int c) {
        double a=Math.sqrt(c);
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<=(int)a;i++){
            if((i*i)+(i*i)==c) return true;
            if(set.contains(i*i)) return true;
            set.add(c-(i*i));
        }
        return false;
    }
}