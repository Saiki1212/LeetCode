class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        for(int num : nums) {
            temp.add(num);
        }
        int j=0;
        while(!temp.isEmpty()) {
            list.add(new ArrayList<>());
            for(int i=0; i<temp.size(); i++) {
                if(!list.get(j).contains(temp.get(i))) {
                    list.get(j).add(temp.get(i));
                    temp.remove(i);
                    i--;
                }
            }
            j++;
            // list.add(new ArrayList(arr));
        }
        return list;
    }
}