class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, ele = nums[0];
        int n = nums.length;
        for(int j = 1; j<n; j++) {
            if(count == 0){ ele = nums[j]; count++;}
            else if(ele == nums[j]) count++;
            else count--;
        }
        return ele;
    }
}