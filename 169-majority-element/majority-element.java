class Solution {
    
    public int majorityElement(int[] nums) {
       int n = nums.length;
       int ele = nums[0], count = 1;
       for(int i=1; i<n; i++) {
           if(count == 0) ele = nums[i];
           if(ele == nums[i]) count++;
           else count--;
       }
       return ele;
    }
}