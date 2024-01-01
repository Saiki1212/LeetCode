class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int m1 = nums[0], m2 = 0;
        for(int i=1; i<n; i++) {
            if(nums[i] >= m1) {
                m2 = m1;
                m1 = nums[i];
            }
            else if(nums[i] < m1 && nums[i] > m2)
                m2 = nums[i];
        }
        m1--;
        m2--;
        return (m1*m2);
    }
}