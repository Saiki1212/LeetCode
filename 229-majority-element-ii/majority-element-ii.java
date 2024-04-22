class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        
        int c1, c2, e1, e2;
        c1 = c2 = 0;
        e1 = e2 = Integer.MAX_VALUE;

        for(int val : nums) {
            if(c1 == 0 && val != e2) {
                e1 = val; c1++;
            }
            else if(c2 == 0 && val != e1) {
                e2 = val; c2++;
            }
            else if(val == e1) c1++;
            else if(val == e2) c2++;
            else {c1--; c2--;}
        }
        c1 = c2 = 0;
        for(int val : nums) {
            if(val == e1) c1++;
            else if(val == e2) c2++;
        }
        if(c1 > n/3) list.add(e1);
        if(c2 > n/3) list.add(e2);

        return list;
    }
}