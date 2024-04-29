class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        CombSum(list, new ArrayList<>(), target, candidates, 0, 0);
        return list;
    }

    public static void CombSum(List<List<Integer>> list, List<Integer> temp, int tar, int[] nums, int i, int sum) {
        if(sum == tar){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int j=i; j<nums.length; j++) {
            if(sum + nums[j] <= tar) {
                temp.add(nums[j]);
                CombSum(list, temp, tar, nums, j, sum+nums[j]);
                temp.remove(temp.size()-1);
            }
        }
    }

}