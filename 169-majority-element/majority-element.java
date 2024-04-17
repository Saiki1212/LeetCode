class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, ele = nums[0];
        for(int j = 1; j<nums.length; j++) {
            int i = nums[j];
            if(count == 0){ ele = i; count++;}
            else if(ele == i) count++;
            else count--;
        }
        return ele;
    }
}