class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        UniqueSum(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public static void UniqueSum(List<List<Integer>> list, List<Integer> temp, int[] nums, int tar, int i) {
        if(tar == 0) {

            list.add(new ArrayList<>(temp));
            return;
        }

        for(int j = i; j<nums.length; j++) {
            if(nums[j] > tar) return;
            if(j>i && nums[j] == nums[j-1]) continue;
            temp.add(nums[j]);
            UniqueSum(list, temp, nums, tar-nums[j], j+1);
            temp.remove(temp.size()-1);
        }
    }

}