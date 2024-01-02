class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        for(int num : nums) {
            temp.add(num);
        }
        while(!temp.isEmpty()) {
            List<Integer> arr = new ArrayList<>();
            for(int i=0; i<temp.size(); i++) {
                if(!arr.contains(temp.get(i))) {
                    arr.add(temp.get(i));
                    temp.remove(i);
                    i--;
                }
            }
            list.add(new ArrayList(arr));
        }
        return list;
    }
}