class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if( i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = n-1;
            while(j < k) {
                int val = nums[i]+nums[j]+nums[k];
                if(val == 0) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    k--; j++;
                    while(nums[k] == nums[k+1] && k > j) k--;
                    while(nums[j] == nums[j-1] && k > j) j++;
                    res.add(new ArrayList<>(temp));
                }
                else if(val > 0) k--;
                else j++;
            }
        }
        return res;
    }
}