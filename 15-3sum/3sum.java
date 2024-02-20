
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        
        Set<List<Integer>> different = new HashSet<>();
        for(int i=0; i<n; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i+1; j<n; j++) {
                int dif = -1 * (nums[i]+nums[j]);
                if(set.contains(dif)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], dif);
                    temp.sort(null);
                    different.add(temp);
                }
                set.add(nums[j]);
            }
        }
        List<List<Integer>> list = new ArrayList<>(different);
        return list;
    }
}