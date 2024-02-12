class Solution {
    
    public int majorityElement(int[] nums) {
       int n = nums.length;
       Set<Integer> set = new HashSet<>();
       int maxi = 0, val = 0;
       for(int i=0; i<n; i++) {
           int c = 1;
           if(!set.contains(nums[i])) {
               for(int j = i+1; j<n; j++) {
                   if(nums[j] == nums[i]) c++;
               }
               set.add(nums[i]);
               if(maxi < c) {
                   val = nums[i];
                   maxi = c;
                }
           }
       }
       return val;
    }
}