class Solution {

    public static void PowerSet(List<List<Integer>> list, List<Integer> temp, int[] nums, int i, int n) {
        if(!list.contains(temp))
            list.add(new ArrayList<>(temp));
        for(int j = i; j<n; j++) {
            // if(j > i && nums[j] == nums[j-1]) continue;
            temp.add(nums[j]);
            PowerSet(list, temp, nums, j+1, n);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        PowerSet(list, new ArrayList<>(), nums, 0, nums.length);
        return list;
    }
}