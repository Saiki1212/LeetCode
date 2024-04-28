class Solution {

    public static void Func(List<List<Integer>> list, int[] nums, int i, List<Integer> temp) {
        if(i == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        Func(list, nums, i+1, temp);
        temp.remove(temp.size()-1);
        Func(list, nums, i+1, temp);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Func(list, nums, 0, new ArrayList<>());

        return list;

    }
}