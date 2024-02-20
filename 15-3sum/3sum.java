
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int previ = 100001;
        for (int i = 0; i < n; i++) {
            if( i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = n-1;
            while(j < k) {
                int val = nums[i] + nums[j] + nums[k];
                if(val < 0) j++;
                else if(val > 0) k--;
                else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    list.add(new ArrayList<>(temp));
                    j++; k--;
                    while(j < k && nums[k+1] == nums[k]) k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                }
            }
        }
        
        return list;
    }
}