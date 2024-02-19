class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>(2);
        int c1 = 0, c2 = 0, el1 = Integer.MAX_VALUE, el2 = el1;
        for(int i : nums)  {
            if(c1 == 0 && i != el2) {
                c1 = 1; el1 = i;
            }
            else if(c2 == 0 && i != el1) {
                c2 = 1; el2 = i;
            }
            else if(el1 == i) c1++;
            else if(el2 == i) c2++;
            else {
                c1--; c2--;
            }
        }
        c1 = 0; c2 = 0;
        for(int i : nums) {
            if(i == el1) c1++;
            else if(i == el2) c2++;
        }
        if(c1 > n/3) list.add(el1);
        if(c2 > n/3) list.add(el2);
        return list;
    }
}